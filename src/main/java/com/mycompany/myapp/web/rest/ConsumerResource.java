package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.ConsumerRepository;
import com.mycompany.myapp.service.ConsumerService;
import com.mycompany.myapp.service.dto.ConsumerDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Consumer}.
 */
@RestController
@RequestMapping("/api/consumers")
public class ConsumerResource {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerResource.class);

    private static final String ENTITY_NAME = "consumer";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConsumerService consumerService;

    private final ConsumerRepository consumerRepository;

    public ConsumerResource(ConsumerService consumerService, ConsumerRepository consumerRepository) {
        this.consumerService = consumerService;
        this.consumerRepository = consumerRepository;
    }

    /**
     * {@code POST  /consumers} : Create a new consumer.
     *
     * @param consumerDTO the consumerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new consumerDTO, or with status {@code 400 (Bad Request)} if the consumer has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ConsumerDTO> createConsumer(@Valid @RequestBody ConsumerDTO consumerDTO) throws URISyntaxException {
        LOG.debug("REST request to save Consumer : {}", consumerDTO);
        if (consumerDTO.getId() != null) {
            throw new BadRequestAlertException("A new consumer cannot already have an ID", ENTITY_NAME, "idexists");
        }
        consumerDTO = consumerService.save(consumerDTO);
        return ResponseEntity.created(new URI("/api/consumers/" + consumerDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, consumerDTO.getId().toString()))
            .body(consumerDTO);
    }

    /**
     * {@code PUT  /consumers/:id} : Updates an existing consumer.
     *
     * @param id the id of the consumerDTO to save.
     * @param consumerDTO the consumerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated consumerDTO,
     * or with status {@code 400 (Bad Request)} if the consumerDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the consumerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ConsumerDTO> updateConsumer(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ConsumerDTO consumerDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update Consumer : {}, {}", id, consumerDTO);
        if (consumerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, consumerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!consumerRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        consumerDTO = consumerService.update(consumerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, consumerDTO.getId().toString()))
            .body(consumerDTO);
    }

    /**
     * {@code PATCH  /consumers/:id} : Partial updates given fields of an existing consumer, field will ignore if it is null
     *
     * @param id the id of the consumerDTO to save.
     * @param consumerDTO the consumerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated consumerDTO,
     * or with status {@code 400 (Bad Request)} if the consumerDTO is not valid,
     * or with status {@code 404 (Not Found)} if the consumerDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the consumerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ConsumerDTO> partialUpdateConsumer(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ConsumerDTO consumerDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update Consumer partially : {}, {}", id, consumerDTO);
        if (consumerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, consumerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!consumerRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ConsumerDTO> result = consumerService.partialUpdate(consumerDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, consumerDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /consumers} : get all the consumers.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of consumers in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ConsumerDTO>> getAllConsumers(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of Consumers");
        Page<ConsumerDTO> page = consumerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /consumers/:id} : get the "id" consumer.
     *
     * @param id the id of the consumerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the consumerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConsumerDTO> getConsumer(@PathVariable("id") Long id) {
        LOG.debug("REST request to get Consumer : {}", id);
        Optional<ConsumerDTO> consumerDTO = consumerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(consumerDTO);
    }

    /**
     * {@code DELETE  /consumers/:id} : delete the "id" consumer.
     *
     * @param id the id of the consumerDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsumer(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete Consumer : {}", id);
        consumerService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
