package com.alderaan.address.postcode;

import com.alderaan.address.city.City;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @since 2024-11-26
 * @see PostcodeServiceImpl
 * @author Jeffrey Spaan
 * @version 1.0
 */
public interface PostcodeService {
    ResponseEntity<List<PostcodeResponse>> findAllPostcodes();
    ResponseEntity<PostcodeResponse> findPostcodeById(Integer id);
    Postcode findPostcodeByCode(String postcodeCode);
    Postcode findOrCreatePostcodeByCode(String postcodeCode, City city);
    ResponseEntity<PostcodeResponse> savePostcode(PostcodeRequest request);
    ResponseEntity<Void> deletePostcodeById(Integer id);
}