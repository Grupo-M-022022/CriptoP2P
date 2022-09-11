package ar.edu.unq.CriptoP2P.utility;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutoMapperComponent {
    @Autowired
    private ModelMapper modelMapper;

    public <S, T> List<T> ToList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <S, T> T To(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }
}
