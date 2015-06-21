package eu.artofcoding.abrechnung.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.nio.file.Path;

public class JAXBHelper<T> {

    public static <T> void serialize(T model, Path path) throws JAXBException, FileNotFoundException {
        final Class<?> modelClass = model.getClass();
        Annotation[] annotations = modelClass.getAnnotations();
        final XmlRootElement annotation = modelClass.getAnnotation(XmlRootElement.class);
        final String namespace = annotation.namespace();
        JAXBContext jaxbContext = JAXBContext.newInstance(namespace);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(model, new FileOutputStream(path.toFile()));
    }

    public static <T> T deserialize(Class<T> model, Path path) throws JAXBException, FileNotFoundException {
        final XmlRootElement annotation = model.getAnnotation(XmlRootElement.class);
        final String namespace = annotation.namespace();
        JAXBContext jaxbContext = JAXBContext.newInstance(namespace);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        @SuppressWarnings("unchecked")
        T unmarshalledObject = (T) unmarshaller.unmarshal(new FileInputStream(path.toFile()));
        return unmarshalledObject;
    }

}
