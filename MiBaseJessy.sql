-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-02-2020 a las 03:58:18
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `consultorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alergia`
--

CREATE TABLE `alergia` (
  `ale_id` int(11) NOT NULL,
  `ale_tipo` varchar(45) DEFAULT NULL,
  `ale_descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alergia_ficha`
--

CREATE TABLE `alergia_ficha` (
  `idAlergia_Ficha` int(11) NOT NULL,
  `Alergia_ale_id` int(11) NOT NULL,
  `FichaMedica_fic_med_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificado`
--

CREATE TABLE `certificado` (
  `cer_id` int(11) NOT NULL,
  `descripcion` varchar(999) DEFAULT NULL,
  `desde` date DEFAULT NULL,
  `hasta` date DEFAULT NULL,
  `ConsultaMedica_con_med_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultaficha`
--

CREATE TABLE `consultaficha` (
  `con_fic_id` int(11) NOT NULL,
  `ConsultaMedica_con_med_id` int(11) NOT NULL,
  `FichaMedica_fic_med_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultamedica`
--

CREATE TABLE `consultamedica` (
  `con_med_id` int(11) NOT NULL,
  `con_med_hora` date DEFAULT NULL,
  `con_med_fecha` date DEFAULT NULL,
  `Turno_tur_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `cue_id` int(11) NOT NULL,
  `Medico_med_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfermedad`
--

CREATE TABLE `enfermedad` (
  `enf_id` int(11) NOT NULL,
  `enf_tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfermedad_ficha`
--

CREATE TABLE `enfermedad_ficha` (
  `idEnfermedad_Ficha` int(11) NOT NULL,
  `Enfermedad_enf_id` int(11) NOT NULL,
  `FichaMedica_fic_med_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fichamedica`
--

CREATE TABLE `fichamedica` (
  `fic_med_id` int(11) NOT NULL,
  `fic_med_fecha` date DEFAULT NULL,
  `fic_med_hora` date DEFAULT NULL,
  `fic_med_grupo_sanguineo` varchar(45) DEFAULT NULL,
  `fic_med_discapacidad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `med_id` int(11) NOT NULL,
  `med_fecha_caducidad` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `med_id` int(11) NOT NULL,
  `med_especialidad` varchar(45) DEFAULT NULL,
  `Persona_per_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`med_id`, `med_especialidad`, `Persona_per_id`) VALUES
(1, 'General', 1),
(2, 'Ginecólogo', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `pac_id` int(11) NOT NULL,
  `per_genero` varchar(45) DEFAULT NULL,
  `Persona_per_id1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `per_id` int(11) NOT NULL,
  `per_cedula` varchar(45) DEFAULT NULL,
  `per_nombre` varchar(45) DEFAULT NULL,
  `per_apellido` varchar(45) DEFAULT NULL,
  `pre_direccion` varchar(45) DEFAULT NULL,
  `per_telefono` varchar(45) DEFAULT NULL,
  `per_fec_nacimiento` varchar(45) DEFAULT NULL,
  `per_mail` varchar(45) DEFAULT NULL,
  `per_contro` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`per_id`, `per_cedula`, `per_nombre`, `per_apellido`, `pre_direccion`, `per_telefono`, `per_fec_nacimiento`, `per_mail`, `per_contro`) VALUES
(1, '0107122418', 'Jessica', 'Caguana', 'Ricaurte El Arenal', '2475662', '08-12-1997', 'jessy@gmail.com', '12345'),
(2, '0107122417', 'Luis', 'Perez', 'Totoracocha', '2456789', '12-12-1990', 'luis@hotmail.com', '12345'),
(3, '0107896253', 'Maria', 'Mendez', 'Totoracocha', '2456786', '12-12-1987', 'maria@hotmail.com', '12345'),
(4, '0107122198', 'Ericka', 'Mendez', 'Azogues', '2475662', '15-03-1997', 'erick@gmail.com', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetamedicamento`
--

CREATE TABLE `recetamedicamento` (
  `rec_med_id` int(11) NOT NULL,
  `rec_med_dosis` varchar(45) DEFAULT NULL,
  `Recetas_rec_id` int(11) NOT NULL,
  `Medicamento_med_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetas`
--

CREATE TABLE `recetas` (
  `rec_id` int(11) NOT NULL,
  `rec_dosis` varchar(45) DEFAULT NULL,
  `rec_frecuencia` varchar(45) DEFAULT NULL,
  `ConsultaMedica_con_med_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretario`
--

CREATE TABLE `secretario` (
  `sec_id` int(11) NOT NULL,
  `sec_rol` varchar(45) DEFAULT NULL,
  `Persona_per_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE `transaccion` (
  `tra_id` int(11) NOT NULL,
  `tra_total` double DEFAULT NULL,
  `Cuenta_cue_id1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `tur_id` int(11) NOT NULL,
  `tur_hora` date DEFAULT NULL,
  `tur_fecha` date DEFAULT NULL,
  `Paciente_pac_id` int(11) NOT NULL,
  `Medico_med_id1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `vac_id` int(11) NOT NULL,
  `vac_descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna_ficha`
--

CREATE TABLE `vacuna_ficha` (
  `idVacuna_Ficha` int(11) NOT NULL,
  `Vacuna_vac_id` int(11) NOT NULL,
  `FichaMedica_fic_med_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alergia`
--
ALTER TABLE `alergia`
  ADD PRIMARY KEY (`ale_id`);

--
-- Indices de la tabla `alergia_ficha`
--
ALTER TABLE `alergia_ficha`
  ADD PRIMARY KEY (`idAlergia_Ficha`),
  ADD KEY `fk_Alergia_Ficha_Alergia1_idx` (`Alergia_ale_id`),
  ADD KEY `fk_Alergia_Ficha_FichaMedica1_idx` (`FichaMedica_fic_med_id`);

--
-- Indices de la tabla `certificado`
--
ALTER TABLE `certificado`
  ADD PRIMARY KEY (`cer_id`),
  ADD KEY `fk_Certificado_ConsultaMedica1_idx` (`ConsultaMedica_con_med_id`);

--
-- Indices de la tabla `consultaficha`
--
ALTER TABLE `consultaficha`
  ADD PRIMARY KEY (`con_fic_id`),
  ADD KEY `fk_ConsultaFicha_ConsultaMedica1_idx` (`ConsultaMedica_con_med_id`),
  ADD KEY `fk_ConsultaFicha_FichaMedica1_idx` (`FichaMedica_fic_med_id`);

--
-- Indices de la tabla `consultamedica`
--
ALTER TABLE `consultamedica`
  ADD PRIMARY KEY (`con_med_id`),
  ADD KEY `fk_ConsultaMedica_Turno1_idx` (`Turno_tur_id`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`cue_id`),
  ADD KEY `fk_Cuenta_Medico1_idx` (`Medico_med_id`);

--
-- Indices de la tabla `enfermedad`
--
ALTER TABLE `enfermedad`
  ADD PRIMARY KEY (`enf_id`);

--
-- Indices de la tabla `enfermedad_ficha`
--
ALTER TABLE `enfermedad_ficha`
  ADD PRIMARY KEY (`idEnfermedad_Ficha`),
  ADD KEY `fk_Enfermedad_Ficha_Enfermedad1_idx` (`Enfermedad_enf_id`),
  ADD KEY `fk_Enfermedad_Ficha_FichaMedica1_idx` (`FichaMedica_fic_med_id`);

--
-- Indices de la tabla `fichamedica`
--
ALTER TABLE `fichamedica`
  ADD PRIMARY KEY (`fic_med_id`);

--
-- Indices de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`med_id`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`med_id`),
  ADD KEY `fk_Medico_Persona1_idx` (`Persona_per_id`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`pac_id`),
  ADD KEY `fk_Paciente_Persona2_idx` (`Persona_per_id1`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`per_id`);

--
-- Indices de la tabla `recetamedicamento`
--
ALTER TABLE `recetamedicamento`
  ADD PRIMARY KEY (`rec_med_id`),
  ADD KEY `fk_RecetaMedicamento_Recetas1_idx` (`Recetas_rec_id`),
  ADD KEY `fk_RecetaMedicamento_Medicamento1_idx` (`Medicamento_med_id`);

--
-- Indices de la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD PRIMARY KEY (`rec_id`),
  ADD KEY `fk_Recetas_ConsultaMedica1_idx` (`ConsultaMedica_con_med_id`);

--
-- Indices de la tabla `secretario`
--
ALTER TABLE `secretario`
  ADD PRIMARY KEY (`sec_id`),
  ADD KEY `fk_Secretario_Persona1_idx` (`Persona_per_id`);

--
-- Indices de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD PRIMARY KEY (`tra_id`),
  ADD KEY `fk_Transaccion_Cuenta2_idx` (`Cuenta_cue_id1`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`tur_id`),
  ADD KEY `fk_Turno_Paciente1_idx` (`Paciente_pac_id`),
  ADD KEY `fk_Turno_Medico2_idx` (`Medico_med_id1`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`vac_id`);

--
-- Indices de la tabla `vacuna_ficha`
--
ALTER TABLE `vacuna_ficha`
  ADD PRIMARY KEY (`idVacuna_Ficha`),
  ADD KEY `fk_Vacuna_Ficha_Vacuna1_idx` (`Vacuna_vac_id`),
  ADD KEY `fk_Vacuna_Ficha_FichaMedica1_idx` (`FichaMedica_fic_med_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alergia`
--
ALTER TABLE `alergia`
  MODIFY `ale_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `alergia_ficha`
--
ALTER TABLE `alergia_ficha`
  MODIFY `idAlergia_Ficha` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `certificado`
--
ALTER TABLE `certificado`
  MODIFY `cer_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `consultaficha`
--
ALTER TABLE `consultaficha`
  MODIFY `con_fic_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `consultamedica`
--
ALTER TABLE `consultamedica`
  MODIFY `con_med_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `cue_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `enfermedad`
--
ALTER TABLE `enfermedad`
  MODIFY `enf_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `fichamedica`
--
ALTER TABLE `fichamedica`
  MODIFY `fic_med_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `med_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `med_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `pac_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `per_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `recetamedicamento`
--
ALTER TABLE `recetamedicamento`
  MODIFY `rec_med_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recetas`
--
ALTER TABLE `recetas`
  MODIFY `rec_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `secretario`
--
ALTER TABLE `secretario`
  MODIFY `sec_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  MODIFY `tra_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `tur_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `vac_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vacuna_ficha`
--
ALTER TABLE `vacuna_ficha`
  MODIFY `idVacuna_Ficha` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alergia_ficha`
--
ALTER TABLE `alergia_ficha`
  ADD CONSTRAINT `fk_Alergia_Ficha_Alergia1` FOREIGN KEY (`Alergia_ale_id`) REFERENCES `alergia` (`ale_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Alergia_Ficha_FichaMedica1` FOREIGN KEY (`FichaMedica_fic_med_id`) REFERENCES `fichamedica` (`fic_med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `certificado`
--
ALTER TABLE `certificado`
  ADD CONSTRAINT `fk_Certificado_ConsultaMedica1` FOREIGN KEY (`ConsultaMedica_con_med_id`) REFERENCES `consultamedica` (`con_med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `consultaficha`
--
ALTER TABLE `consultaficha`
  ADD CONSTRAINT `fk_ConsultaFicha_ConsultaMedica1` FOREIGN KEY (`ConsultaMedica_con_med_id`) REFERENCES `consultamedica` (`con_med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ConsultaFicha_FichaMedica1` FOREIGN KEY (`FichaMedica_fic_med_id`) REFERENCES `fichamedica` (`fic_med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `consultamedica`
--
ALTER TABLE `consultamedica`
  ADD CONSTRAINT `fk_ConsultaMedica_Turno1` FOREIGN KEY (`Turno_tur_id`) REFERENCES `turno` (`tur_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `fk_Cuenta_Medico1` FOREIGN KEY (`Medico_med_id`) REFERENCES `medico` (`med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `enfermedad_ficha`
--
ALTER TABLE `enfermedad_ficha`
  ADD CONSTRAINT `fk_Enfermedad_Ficha_Enfermedad1` FOREIGN KEY (`Enfermedad_enf_id`) REFERENCES `enfermedad` (`enf_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Enfermedad_Ficha_FichaMedica1` FOREIGN KEY (`FichaMedica_fic_med_id`) REFERENCES `fichamedica` (`fic_med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `fk_Medico_Persona1` FOREIGN KEY (`Persona_per_id`) REFERENCES `persona` (`per_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `fk_Paciente_Persona2` FOREIGN KEY (`Persona_per_id1`) REFERENCES `persona` (`per_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recetamedicamento`
--
ALTER TABLE `recetamedicamento`
  ADD CONSTRAINT `fk_RecetaMedicamento_Medicamento1` FOREIGN KEY (`Medicamento_med_id`) REFERENCES `medicamento` (`med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_RecetaMedicamento_Recetas1` FOREIGN KEY (`Recetas_rec_id`) REFERENCES `recetas` (`rec_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD CONSTRAINT `fk_Recetas_ConsultaMedica1` FOREIGN KEY (`ConsultaMedica_con_med_id`) REFERENCES `consultamedica` (`con_med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `secretario`
--
ALTER TABLE `secretario`
  ADD CONSTRAINT `fk_Secretario_Persona1` FOREIGN KEY (`Persona_per_id`) REFERENCES `persona` (`per_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD CONSTRAINT `fk_Transaccion_Cuenta2` FOREIGN KEY (`Cuenta_cue_id1`) REFERENCES `cuenta` (`cue_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `fk_Turno_Medico2` FOREIGN KEY (`Medico_med_id1`) REFERENCES `medico` (`med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Turno_Paciente1` FOREIGN KEY (`Paciente_pac_id`) REFERENCES `paciente` (`pac_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vacuna_ficha`
--
ALTER TABLE `vacuna_ficha`
  ADD CONSTRAINT `fk_Vacuna_Ficha_FichaMedica1` FOREIGN KEY (`FichaMedica_fic_med_id`) REFERENCES `fichamedica` (`fic_med_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Vacuna_Ficha_Vacuna1` FOREIGN KEY (`Vacuna_vac_id`) REFERENCES `vacuna` (`vac_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
