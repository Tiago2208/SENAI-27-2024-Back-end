package com.example.controller;

import com.example.domain.Item;
import com.example.domain.ItemRepository;

import javax.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject; // Importa a classe correta para injeção de dependência
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {

    @Inject
    ItemRepository repository;

    @GET
    public List<Item> getAll() {
        return repository.listAll();
    }

    @POST
    public void create(Item item) {
        repository.persist(item);
    }

    @PUT
    public void update(Item item) {
        repository.persist(item);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}
