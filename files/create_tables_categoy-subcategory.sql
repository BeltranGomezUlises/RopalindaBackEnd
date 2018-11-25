create
	table
		category ( id serial primary key not null,
		"name" varchar(50) not null,
		icon varchar(400) not null,
		active bool not null default true
		);
	
create
	table
		subcategory(id serial primary key not null,
		"name" varchar(50) not null,
		category int not null,
		icon varchar(400) not null,
		active bool not null default true,
		constraint fk_subcategory_category foreign key (category) references category(id) 
		);