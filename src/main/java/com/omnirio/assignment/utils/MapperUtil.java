package com.omnirio.assignment.utils;


import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


@Slf4j
public class MapperUtil {

	private MapperUtil() {
		throw new IllegalStateException("Utility Class");
	}

	public static <T> T convertModelToEntity(Object source, Class<T> destinationType) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(source, destinationType);
	}

	public static <T> T convertEntityToModel(Object source, Class<T> destinationType) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(source, destinationType);
	}



}
