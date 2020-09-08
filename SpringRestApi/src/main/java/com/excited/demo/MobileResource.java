package com.excited.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileResource {
	
	@Autowired
	MobileRepository mobilerepo;
	
	@GetMapping("mobile")
	public List<Mobile> getMobiles()
	{
		List<Mobile> mobiles=(List<Mobile>) mobilerepo.findAll();
        return mobiles;
		
	}
	
	@GetMapping("mobile/{id}")
	public ResponseEntity<Mobile> getMobileById(@PathVariable("id") int id) {
		Optional<Mobile> mobiledata=mobilerepo.findById(id);
		if (mobiledata.isPresent()) {
		      return new ResponseEntity<>(mobiledata.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		
	}
	
	@PostMapping("mobile")
	  public ResponseEntity<Mobile> createMobile(@RequestBody Mobile mobile2) {
	    try {
	    	Mobile createMobile=mobilerepo.save(new Mobile(mobile2.getId(),mobile2.getName(),mobile2.getCost()));
	
	      return new ResponseEntity<>(createMobile, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	@PutMapping("mobile/{id}")
	  public ResponseEntity<Mobile> updateTutorial(@PathVariable("id") Integer id, @RequestBody Mobile mobile1) {
	    Optional<Mobile> mobiledata = mobilerepo.findById(id);

	    if (mobiledata.isPresent()) {
	      Mobile details = mobiledata.get();
	      details.setName(mobile1.getName());
	      details.setCost(mobile1.getCost());
	      return new ResponseEntity<>(mobilerepo.save(details), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("mobile/{id}")
	public ResponseEntity<Mobile> deleteMobileById(@PathVariable("id") int id) {
		try {
			mobilerepo.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		    }
		
	}

}
