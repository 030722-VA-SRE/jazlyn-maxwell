-- Drop tables if they already exist
drop table if exists charms;
drop table if exists users;


-- Create new database tables
create table users(
	user_id serial primary key,
	user_name varchar(30) unique not null,
	user_pass varchar(30) not null,
	user_balance integer not null
);

create table charms(
	charm_id serial primary key,
	charm_name varchar(50) not null,
	charm_desc varchar(250) not null,
	charm_price integer not null,
	charm_region varchar(50) not null,
	charm_country varchar(50) not null,
	user_id integer references users(user_id)
);

-- Insert values into tables
insert into users(user_name, user_pass, user_balance) values 
	('Salubra', '12345678', 0),
	('Sly', '12345678', 0),
	('Leg Eater', '12345678', 0),
	('Iselda', '12345678', 0),
	('Candelaria', '12345678', 0);
	
insert into charms(charm_name, charm_desc, charm_price, charm_region, charm_country, user_id) values
	('Lifeblood Heart', 'When resting, the bearer will gain a coating of lifeblood that protects from a modest amount of damage.', 250, 'Forgotten Crossroads', 'Hallownest', 1),
	('Longnail', 'Increases the range of the bearer''s nail, allowing them to strike foes from further away.', 300, 'Forgotten Crossroads', 'Hallownest', 1),
	('Steady Body', 'Allows one to stay steady and keep attacking.', 120, 'Forgotten Crossroads', 'Hallownest', 1),
	('Shaman Stone', 'Increases the power of spells, dealing more damage to foes.', 220, 'Forgotten Crossroads', 'Hallownest', 1),
	('Quick Focus', 'Increases the speed of focusing soul, allowing the bearer to heal damage faster.', 800, 'Forgotten Crossroads', 'Hallownest', 1),
	('Gathering Swarm', 'Useful for those who can''t bear to leave anything behind, no matter how insignificant.', 300, 'Dirtmouth', 'Hallownest', 2),
	('Stalwart Shell', 'Makes it easier to escape from dangerous situations.', 200, 'Dirtmouth', 'Hallownest', 2),
	('Heavy Blow', 'Increases the force of the bearer''s nail, causing enemies to recoil further when hit.', 350, 'Dirtmouth', 'Hallownest', 2),
	('Sprintmaster', 'Increases the running speed of the bearer, allowing them to avoid danger or overtake rivals.', 400, 'Dirtmouth', 'Hallownest', 2),
	('Fragile Heart', 'Increases the health of the bearer, allowing them to take more damage.', 350, 'Fungal Wastes', 'Hallownest', 3),
	('Fragile Greed', 'Causes the bearer to find more Geo when defeating enemies.', 250, 'Fungal Wastes', 'Hallownest', 3),
	('Fragile Strength', 'Strengthens the bearer, increasing the damage they deal to enemies with their nail.', 600, 'Fungal Wastes', 'Hallownest', 3),
	('Wayward Compass', 'Whispers its location to the bearer whenever a map is open, allowing wanderers to pinpoint their current location.', 220, 'Dirtmouth', 'Hallownest', 4),
	('Hollow Pearl', 'Empty, tarnished sphere. There is no trace of nacre left, but it retains just a hint of bluish sheen. It creates fervour when destroying surrounding objects.', 100, 'Mercy Dreams', 'Cvstodia', 5),
	('Moss Preserved in Glass', 'Minute jar filled with moss. The tiny white flowers that shimmer inside can grant some protection against toxins.', 1500, 'Mercy Dreams', 'Cvstodia', 5),
	('Ember of the Holy Cremation', 'Ember crystallised through a long forgotten ritual. It retains some of the heat of a bonfire lit on a different land. Tempers the heart, increasing the defences of whoever carries it. ', 5000, 'Graveyard of the Peaks', 'Cvstodia', 5),
	('Calcified Eye of Erudition', 'Eyeball belonging to Alavaroz the scribe, who glimpsed the truth hidden to so many other eyes. Its stony scrutiny reveals the vital essence of enemies. ', 1200, 'Graveyard of the Peaks', 'Cvstodia', 5),
	('Wicker Knot', 'Bead braided in a spiral motion, covered with a light coat of varnish that has protected it from the wear and tear of the years. A mother''s hands worked these strands and blessed them. Their influence provides protection from toxic damage.', 4000, 'The Sleeping Canvases', 'Cvstodia', 5);

-- Display table contents
select * from charms as c
join users as u on c.user_id = u.user_id;

select * from charms as c
join users as u on c.user_id = u.user_id
where charm_name like '%Heart%'
and charm_desc like'%damage%'
and true;


