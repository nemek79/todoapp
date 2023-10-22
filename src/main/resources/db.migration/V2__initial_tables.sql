USE todoappbd;

CREATE TABLE t_estados_tarea (

	id 				INT UNSIGNED 	AUTO_INCREMENT 	PRIMARY KEY,
	descripcion	    VARCHAR(64) NOT NULL,
    color           VARCHAR(16)

);

CREATE TABLE t_prioridades (

	id 				INT UNSIGNED 	AUTO_INCREMENT 	PRIMARY KEY,
	descripcion	    VARCHAR(64) NOT NULL,
    color           VARCHAR(16)
	
);

CREATE TABLE t_grupos (

	id 				INT UNSIGNED 	AUTO_INCREMENT 	PRIMARY KEY,
	descripcion	    VARCHAR(64) NOT NULL,
    color           VARCHAR(16),
    usuario         VARCHAR(64) NOT NULL

);

CREATE TABLE t_tareas (

	id 				INT UNSIGNED 	AUTO_INCREMENT 	PRIMARY KEY,
	fecha_alta      DATE            NOT NULL,
    fecha_cierre    DATE            NOT NULL,
    estado_id       INT UNSIGNED    NOT NULL,
    titulo          VARCHAR(128)    NOT NULL,
    descripcion     VARCHAR(512)    ,
    grupo_id        INT UNSIGNED    NOT NULL,
    prioridad_id    INT UNSIGNED    NOT NULL
	
);

ALTER TABLE t_tareas
	ADD CONSTRAINT fk_estados_tarea
	FOREIGN KEY (estado_id)
		REFERENCES t_estados_tarea(id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

ALTER TABLE t_tareas
	ADD CONSTRAINT fk_prioridades
	FOREIGN KEY (prioridad_id)
		REFERENCES t_prioridades(id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

ALTER TABLE t_tareas
	ADD CONSTRAINT fk_grupos
	FOREIGN KEY (grupo_id)
		REFERENCES t_grupos(id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;