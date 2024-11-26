package com.alderaan.address.postcode;

import com.alderaan.address.common.constant.HttpConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HttpConstant.Request.Path.POSTCODE)
record PostcodeController(PostcodeService postcodeService) {

    @GetMapping
    public ResponseEntity<List<PostcodeResponse>> getPostcode() {
        return postcodeService.findAllPostcodes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostcodeResponse> getPostcodeById(@PathVariable Integer id) {
        return postcodeService.findPostcodeById(id);
    }

    @PostMapping
    public ResponseEntity<PostcodeResponse> createPostcode(@RequestBody PostcodeRequest request) {
        return postcodeService.savePostcode(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostcodeById(@PathVariable Integer id) {
        return postcodeService.deletePostcodeById(id);
    }
}
