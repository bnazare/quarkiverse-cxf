package io.quarkiverse.cxf.transport;

import java.io.IOException;

import org.apache.cxf.Bus;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.binding.soap.model.SoapBindingInfo;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.transport.http.DestinationRegistry;
import org.apache.cxf.transport.http.HttpDestinationFactory;
import org.apache.cxf.ws.addressing.EndpointReferenceType;

public class UndertowDestinationFactory extends SoapTransportFactory {
    @Override
    public Destination getDestination(EndpointInfo ei, Bus bus) throws IOException {
        String address = ei.getAddress();
        BindingInfo bi = ei.getBinding();
        String transId = ei.getTransportId();
        if (bi instanceof SoapBindingInfo) {
            transId = ((SoapBindingInfo)bi).getTransportURI();
            if (transId == null) {
                transId = ei.getTransportId();
            }
        }
        //TODO return new quarkus destination
        return null;
    }
    @Override
    public Conduit getConduit(EndpointInfo ei, EndpointReferenceType target, Bus bus) throws IOException {
        String address = target == null ? ei.getAddress() : target.getAddress().getValue();
        BindingInfo bi = ei.getBinding();
        String transId = ei.getTransportId();
        if (bi instanceof SoapBindingInfo) {
            transId = ((SoapBindingInfo)bi).getTransportURI();
            if (transId == null) {
                transId = ei.getTransportId();
            }
        }
        //TODO return new quarkus conduit
        return null;
    }
}
