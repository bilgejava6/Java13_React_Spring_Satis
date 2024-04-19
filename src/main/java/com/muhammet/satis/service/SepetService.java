package com.muhammet.satis.service;

import com.muhammet.satis.dto.request.SepetUrunEklemeRequestDto;
import com.muhammet.satis.entity.Sepet;
import com.muhammet.satis.entity.SepetDetay;
import com.muhammet.satis.entity.Urun;
import com.muhammet.satis.repository.SepetDetayRepository;
import com.muhammet.satis.repository.SepetRepository;
import com.muhammet.satis.repository.UrunRepository;
import com.muhammet.satis.view.VwSepetDetay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SepetService {
    private final SepetRepository sepetRepository;
    private final SepetDetayRepository sepetDetayRepository;
    private final UrunRepository urunRepository;

    public void sepeteEkle(SepetUrunEklemeRequestDto dto){
        /**
         * 1- İlgili kullanıcıya ait sepet var mı?
         * 2- sepet var sepetin içide eklenmek isteilen ürün var mı?
         * 3- ekleme yapılabilir
         */
        Optional<Sepet> sepet = sepetRepository.findOptionalByUserId(dto.getUserId());
        Sepet editSepet;
        // sepet yok ise oluştur
        editSepet = sepet.orElseGet(() -> sepetRepository.save(Sepet.builder()
                .adet(0)
                .toplamFiyat(0)
                .userId(dto.getUserId())
                .build()));
        Optional<SepetDetay> sepetDetay =
                sepetDetayRepository.findOptionalBySepetIdAndUrunId(editSepet.getId(),dto.getUrunId());
        if(sepetDetay.isEmpty()){
            sepetDetayRepository.save(
                    SepetDetay.builder()
                            .adet(dto.getAdet())
                            .fiyat(dto.getFiyat())
                            .toplamFiyat(dto.getAdet()*dto.getFiyat())
                            .sepetId(editSepet.getId())
                            .urunId(dto.getUrunId())
                            .build()
            );
            editSepet.setAdet(editSepet.getAdet()+dto.getAdet());
            editSepet.setToplamFiyat(editSepet.getToplamFiyat()+ (dto.getAdet()*dto.getFiyat()));
            sepetRepository.save(editSepet);
        }else{
            SepetDetay editSepetDetay = sepetDetay.get();
            editSepetDetay.setAdet(editSepetDetay.getAdet()+dto.getAdet());
            editSepetDetay.setFiyat(editSepetDetay.getFiyat()+ (dto.getAdet()*dto.getFiyat()));
            sepetDetayRepository.save(editSepetDetay);
        }

    }

    public List<VwSepetDetay> getAll(Long userId){
        Optional<Sepet> sepet = sepetRepository.findOptionalByUserId(userId);
        Sepet result;
        result = sepet.orElseGet(() -> sepetRepository.save(Sepet.builder()
                .userId(userId)
                .toplamFiyat(0)
                .adet(0)
                .build()));
        List<VwSepetDetay> vwSepetDetays = new ArrayList<>();
        List<SepetDetay> sepetDetayList = sepetDetayRepository.findAllBySepetId(result.getId());
        sepetDetayList.forEach(s->{
            Optional<Urun> urun = urunRepository.findById(s.getUrunId());
            vwSepetDetays.add(
                    VwSepetDetay.builder()
                            .aciklama(urun.get().getAciklama())
                            .ad(urun.get().getAd())
                            .adet(s.getAdet())
                            .fiyat(urun.get().getFiyat())
                            .resim(urun.get().getResim())
                            .toplamFiyat(s.getAdet()*s.getFiyat())
                            .urunId(urun.get().getId())
                            .build()
            );
        });
        return  vwSepetDetays;
    }
}
