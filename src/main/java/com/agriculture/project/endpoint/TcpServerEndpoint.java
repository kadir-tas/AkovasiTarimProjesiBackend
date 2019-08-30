package com.agriculture.project.endpoint;

import com.agriculture.project.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class TcpServerEndpoint {

    private static final byte[] TCP_RETURN_OK = "OK".getBytes();
    private static final byte[] TCP_RETURN_BAD = "BAD".getBytes();

    private ModulesService modulesService;

    @Autowired
    public TcpServerEndpoint(ModulesService modulesService) {
        this.modulesService = modulesService;
    }

    @ServiceActivator(inputChannel = "serviceChannel")
    public byte[] process(String message) throws InterruptedException {
        if (modulesService.updateModuleValues(message)) {
            return TCP_RETURN_OK;
        }
        return TCP_RETURN_BAD;
    }

}