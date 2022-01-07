package com.phoenixhell.springbootbase.converter;

import com.phoenixhell.springbootbase.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author phoenixhell
 * @since 2022/1/7 0007-下午 3:55
 *
 * 自定义converter  application/x-custom
 */
public class CustomMessageConverter implements HttpMessageConverter<Person> {
    //读  列子: @requestBody Person person 包装参数到bean
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }


    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-custom");
    }

    //canRead 为false 这边不会调用
    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义协议数据写出
        String data= person.getName()+";"+person.getAge();
        outputMessage.getBody().write(data.getBytes());
    }
}
