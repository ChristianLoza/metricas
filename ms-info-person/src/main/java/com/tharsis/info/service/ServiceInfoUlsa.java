package com.tharsis.info.service;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author christian
 */
@WebService(name = "usuarioService",targetNamespace ="http://academico.ulasalle.edu.pe:8080/" )
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ServiceInfoUlsa {
    
}
