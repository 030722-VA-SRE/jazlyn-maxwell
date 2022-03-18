-- Drop tables if they already exist
drop table if exists charm;
drop table if exists region;
drop table if exists account;
drop table if exists "user";


-- Create new database tables
create table "user"(
	id serial primary key,
	name varchar(20) not null,
	username varchar(30) unique not null,
	password varchar(30) not null
);

create table account(
	id serial primary key,
	balance integer,
	user_id integer references "user"(id)
);

create table region(
	id serial primary key,
	name varchar(30) not null,
	country varchar(20) not null
);

create table charm(
	id serial primary key,
	name varchar(50) not null,
	description varchar(250) not null,
	price integer not null,
	region_id integer references region(id),
	user_id integer references "user"(id)
);

-- Insert values into tables
insert into "user"(name, username, password) values 
	('Salubra', 'charm_lover', '12345678'),
	('Sly', 'great_nailsage', '12345678'),
	('Leg Eater', 'leg_eater', '12345678'),
	('Iselda', 'mrs_cartographer', '12345678'),
	('Candelaria', 'flea_market', '12345678');
	
insert into account(balance, user_id) values 
	(0, 1),
	(0, 2),
	(0, 3),
	(0, 4),
	(0, 5);
	
insert into region(name, country) values 
	('Forgotten Crossroads', 'Hallownest'),
	('Dirtmouth', 'Hallownest'),
	('Fungal Wastes', 'Hallownest'),
	('Mercy Dreams', 'Cvstodia'),
	('Graveyard of the Peaks', 'Cvstodia'),
	('The Sleeping Canvases', 'Cvstodia');
	
insert into charm(name, description, price, region_id, user_id) values
	('Lifeblood Heart', 'When resting, the bearer will gain a coating of lifeblood that protects from a modest amount of damage.', 250, 1, 1),
	('Longnail', 'Increases the range of the bearer''s nail, allowing them to strike foes from further away.', 300, 1, 1),
	('Steady Body', 'Allows one to stay steady and keep attacking.', 120, 1, 1),
	('Shaman Stone', 'Increases the power of spells, dealing more damage to foes.', 220, 1, 1),
	('Quick Focus', 'Increases the speed of focusing soul, allowing the bearer to heal damage faster.', 800, 1, 1),
	('Gathering Swarm', 'Useful for those who can''t bear to leave anything behind, no matter how insignificant.', 300, 2, 2),
	('Stalwart Shell', 'Makes it easier to escape from dangerous situations.', 200, 2, 2),
	('Heavy Blow', 'Increases the force of the bearer''s nail, causing enemies to recoil further when hit.', 350, 2, 2),
	('Sprintmaster', 'Increases the running speed of the bearer, allowing them to avoid danger or overtake rivals.', 400, 2, 2),
	('Fragile Heart', 'Increases the health of the bearer, allowing them to take more damage.', 350, 3, 3),
	('Fragile Greed', 'Causes the bearer to find more Geo when defeating enemies.', 250, 3, 3),
	('Fragile Strength', 'Strengthens the bearer, increasing the damage they deal to enemies with their nail.', 600, 3, 3),
	('Wayward Compass', 'Whispers its location to the bearer whenever a map is open, allowing wanderers to pinpoint their current location.', 220, 2, 4),
	('Hollow Pearl', 'Empty, tarnished sphere. There is no trace of nacre left, but it retains just a hint of bluish sheen. It creates fervour when destroying surrounding objects.', 100, 4, 5),
	('Moss Preserved in Glass', 'Minute jar filled with moss. The tiny white flowers that shimmer inside can grant some protection against toxins.', 1500, 4, 5),
	('Ember of the Holy Cremation', 'Ember crystallised through a long forgotten ritual. It retains some of the heat of a bonfire lit on a different land. Tempers the heart, increasing the defences of whoever carries it. ', 5000, 5, 5),
	('Calcified Eye of Erudition', 'Eyeball belonging to Alavaroz the scribe, who glimpsed the truth hidden to so many other eyes. Its stony scrutiny reveals the vital essence of enemies. ', 1200, 5, 5),
	('Wicker Knot', 'Bead braided in a spiral motion, covered with a light coat of varnish that has protected it from the wear and tear of the years. A mother''s hands worked these strands and blessed them. Their influence provides protection from toxic damage.', 4000, 6, 5);

-- Display table contents
select * from charm
join "user" as u on charm.user_id = u.id 
join region on charm.region_id = region.id;
