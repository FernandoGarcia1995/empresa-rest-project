package com.company.project.service;


import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.project.config.ErrorConfig;
import com.company.project.dto.RegistrationDto;
import com.company.project.exception.DepartamentoNotFoundException;
import com.company.project.exception.UsernameExistsException;
import com.company.project.interfaces.UserService;
import com.company.project.model.Departamento;
import com.company.project.model.Empleado;
import com.company.project.model.Rol;
import com.company.project.model.User;
import com.company.project.repository.DepartamentoRepository;
import com.company.project.repository.EmpleadoRepository;
import com.company.project.repository.UserRepository;
import com.company.project.response.CommonResponse;
import com.company.project.response.object.Token;

@Service
public class UserServiceImpl implements UserService ,UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (user != null)
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					user.getAuthorities());
		else
			throw new UsernameNotFoundException("Username o contrasenha invalido.");
	}

	@Override
	public CommonResponse registration(RegistrationDto registrationDto) throws Exception {
		
		if(userRepository.existsUserByUsername(registrationDto.getUsername()))
			throw new UsernameExistsException(ErrorConfig.ERR_USER_EXISTS);
		else if(!departamentoRepository.existsDepartamentoByNombre(registrationDto.getDepartamento())) 
			throw new DepartamentoNotFoundException(ErrorConfig.ERR_DEPARTMENT_NOT_FOUND);
	
		User userSave = new User();
		Empleado empleadoSave = new Empleado();
		Departamento departamentoSave = new Departamento();
		
		userSave.setUsername(registrationDto.getUsername());
		userSave.setPassword(encondePassword(registrationDto.getPassword()));
		userSave.setEmail(registrationDto.getEmail());
		userSave.setRole(Rol.ROLE_EMPLOYEE);
		
		departamentoSave = departamentoRepository.findByNombre(registrationDto.getDepartamento());
		empleadoSave.setDepartamento(departamentoSave);
		
		empleadoSave.setNombre(registrationDto.getNombre());
		empleadoSave.setApellido(registrationDto.getApellido());
		empleadoSave.setFechaNacimiento(registrationDto.getFechaNacimiento());
		empleadoSave.setTelefono(registrationDto.getTelefono());
		empleadoSave.setDireccion(registrationDto.getDireccion());
		empleadoSave.setSalario(registrationDto.getSalario());
		
		userSave.setEmpleado(empleadoSave);

		empleadoRepository.save(empleadoSave);
		userRepository.save(userSave);

		guardarUser(userSave);
		
		return new CommonResponse();
	}

	@Override
	public Token httpBasicToken(RegistrationDto userDto) {
		Token token = new Token();
		token.setTokenName(Base64.getEncoder().encodeToString((userDto.getUsername() + ":" + userDto.getPassword()).getBytes()));
		return token;
	}
	
	public User guardarUser(User user) {
		User savedUser = new User();
		try {
			savedUser = userRepository.save(user);
		} catch (Exception ex) {
			return savedUser;
		}
		return savedUser;
	}
	
	
	@Override
	public String encondePassword(String password) {
		BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
		return encrypt.encode(password);
	}

}
