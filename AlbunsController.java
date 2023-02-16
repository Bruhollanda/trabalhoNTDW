package olamundo.controller;

import olamundo.domain.dto.AlbumCreateRequest;
import olamundo.domain.dto.AlbumFilterRequest;
import olamundo.domain.dto.AlbumResponse;
import domain.dto.AlbumUpdateRequest;
import service.AlbunsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AlbunsController {

    private final AlbunsService service;

    public AlbunsController(final AlbunsService service) {
        this.service = service;
    }

    @GetMapping(value = "api/albuns")
    public ResponseEntity<List<AlbumResponse>> listar(AlbumFilterRequest filter) {
        var listaDeAlbuns = service.listar(filter);
        return ResponseEntity.ok(listaDeAlbuns);
    }

    @GetMapping(value = "api/albuns/{id}")
    public ResponseEntity<AlbumResponse> buscarPorId(@PathVariable Integer id) {
        var albumResponse = service.buscarPorId(id);
        return ResponseEntity.ok(albumResponse);
    }

    @GetMapping(value = "api/albuns/nome/{nomeParam}")
    public ResponseEntity<AlbumResponse> buscarPorNome(@PathVariable String nomeParam) {
        var albumResponse = service.buscarPorNome(nomeParam);
        return ResponseEntity.ok(albumResponse);
    }

    @PostMapping(value = "api/albuns")
    public ResponseEntity<AlbumResponse> criarAlbum(@RequestBody @Valid AlbumCreateRequest album) {
        var albumResponse = service.criarAlbum(album);
        return ResponseEntity.ok(albumResponse);
    }

    @PutMapping(value = "api/albuns/{idAlbum}")
    public ResponseEntity<AlbumResponse> atualizarAlbum(
            @PathVariable Integer idAlbum,
            @RequestBody @Valid AlbumUpdateRequest albumUpdateRequest) {
        var album = service.atualizarAlbum(idAlbum, albumUpdateRequest);
        return ResponseEntity.ok(album);
    }

    @DeleteMapping(value = "api/albuns/{idAlbum}")
    public ResponseEntity<AlbumResponse> deletarAlbum(@PathVariable Integer idAlbum) {
        var album = service.deletarAlbum(idAlbum);
        return ResponseEntity.ok(album);
    }
}
