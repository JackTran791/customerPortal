package com.java.customerportal.controller;

import com.java.customerportal.dto.gif.GifDto;
import com.java.customerportal.dto.gif.GifTagDto;
import com.java.customerportal.dto.gif.TagRequestDto;
import com.java.customerportal.exception.domain.ExceptionHandling;
import com.java.customerportal.service.GifService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gif")
@AllArgsConstructor
@Api(tags = "Gif Endpoint", value = "Controller for Gif Service")
public class GifController extends ExceptionHandling {
    private final GifService gifService;

    @PutMapping("/{username}")
    public ResponseEntity<?> saveTag(@PathVariable("username") String username,
                                     @RequestBody GifDto gifDto) {
        gifService.saveTag(username, gifDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{username}")
    public List<GifDto> findAllByUser(@PathVariable("username") String username) {
        return gifService.findAllByUser(username);
    }

    @PutMapping("/tag")
    public ResponseEntity<?> putTag(@RequestBody TagRequestDto tagRequestDto) {
        gifService.tagGif(tagRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
