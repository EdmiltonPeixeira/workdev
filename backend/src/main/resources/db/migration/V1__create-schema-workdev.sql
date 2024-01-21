create table colaboradores (
    id int not null auto_increment,
    nome varchar(100) not null,

    primary key(id)
);

create table workshops (
    id int not null auto_increment,
    nome varchar(150) not null,
    dataRealizacao timestamp not null,
    descricao varchar(50),

    primary key(id)
);

create table atas (
    id int not null auto_increment,
    workshop_id int not null,
    foreign key (workshop_id) references workshops(id),

    primary key(id)
);

create table atas_colaboradores (
    ata_id int not null,
    colaborador_id int not null,

    primary key(ata_id, colaborador_id),
    foreign key(ata_id) references atas(id),
    foreign key(colaborador_id) references colaboradores(id)
);