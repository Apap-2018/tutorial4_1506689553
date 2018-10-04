package com.apap.tutorial4.service;

import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.repository.DealerDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DealerServiceImpl implements DealerService {
    @Autowired
    private DealerDb dealerDb;

    @Override
    public Optional<DealerModel> getDealerDetailById(Long id){
        return dealerDb.findById(id);
    }

    @Override
    public void addDealer(DealerModel dealer) {
        dealerDb.save(dealer);
    }

    @Override
    public void deleteDealer(DealerModel dealer) { 
    	dealerDb.delete(dealer);
    }

	@Override
	public void updateDealer(Optional<DealerModel> dealer, Long dealerId) {
		// TODO Auto-generated method stub
		DealerModel dealerUpdate = dealerDb.getOne(dealerId);
		dealerUpdate.setAlamat(dealer.get().getAlamat());
		dealerUpdate.setNotelp(dealer.get().getNotelp());;
		dealerDb.save(dealerUpdate);

		
	}

	@Override
	public void sortCar(DealerModel dealer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DealerModel> getAllDealer() {
		// TODO Auto-generated method stub
		return dealerDb.findAll();
	}
}
