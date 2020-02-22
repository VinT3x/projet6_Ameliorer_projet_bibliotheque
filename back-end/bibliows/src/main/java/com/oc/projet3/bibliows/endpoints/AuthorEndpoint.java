package com.oc.projet3.bibliows.endpoints;

import com.oc.projet3.bibliows.exceptions.WSException;
import com.oc.projet3.bibliows.service.AuthorService;
import com.oc.projet3.bibliows.service.BookServiceImpl;
import com.oc.projet3.gs_ws.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.ws.rs.core.Context;
import javax.xml.ws.handler.MessageContext;

@Endpoint
public class AuthorEndpoint {

    private static Logger logger = LogManager.getLogger(BookServiceImpl.class);

    // add the attribute to your implementation
    @Context
    private MessageContext context;

    final
    private AuthorService authorService;

    private static final String NAMESPACE_URI = "http://oc.com/projet3/bibliows/service/biblio-producing-web-service";

    @Autowired
    public AuthorEndpoint(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createAuthorRequest")
    @ResponsePayload
    public CreateAuthorResponse createAuthor(
            @RequestPayload CreateAuthorRequest request
    ) throws WSException {
        return authorService.createAuthor(request);

    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateAuthorRequest")
    @ResponsePayload
    public UpdateAuthorResponse updateAuthor(@RequestPayload UpdateAuthorRequest request) throws WSException {

        return authorService.updateAuthor(request);

    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteAuthorRequest")
    @ResponsePayload
    public DeleteAuthorResponse deleteAuthor(@RequestPayload DeleteAuthorRequest request) throws WSException {

        return authorService.deleteAuthor(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findAuthorsRequest")
    @ResponsePayload
    public FindAuthorsResponse findAuthor(@RequestPayload FindAuthorsRequest request) throws WSException {

        return authorService.findAuthor(request);
    }

}
