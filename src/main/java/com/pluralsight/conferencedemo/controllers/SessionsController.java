package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/sessions")
@RequiredArgsConstructor
public class SessionsController {

    private final SessionRepository sessionRepository;

    /***
     * Spring MVC passes the List of Sessions to Jackson which is a serialization library,
     * which will turn those Sessions to JSON.
     */
    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    /***
     * Spring RestController returns 200 response by default,
     * here we override that behaviour with @ReponseStatus annotation
     * saveAndFlush() method flushes changes to DB after the save immediately
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    /***
     * When deleting a record we have to deal with cascades
     * if for example session has children records we would
     * not be allow to delete a session we would get foreign
     * key constraint violation. We first have to delete the
     * children records for session.
     */
    @DeleteMapping(value = "{id}")
    public void deleteSession(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }

    /***
     * Updating can be done in PUT and PATCH http methods
     * Usually PUT is a full object update - includes both changed and unchanged fields
     * PATCH is used for partial updates, unchanged fields are not populated
     */
    @PutMapping(value = "{id}")
    public Session updateSession(@PathVariable Long id, @RequestBody Session session) {
        //TODO: add validation that all attributes are passed in, otherwise return a 400 bad payload.
        Session existing = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existing, "id");
        return sessionRepository.saveAndFlush(existing);
    }
}
