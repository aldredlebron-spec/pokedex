package com.pokedex;

import com.pokedex.model.Pokemon;
import com.pokedex.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final PokemonRepository pokemonRepository;

    public DataSeeder(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public void run(String... args) {
        if (pokemonRepository.count() == 0) {
            List<Pokemon> gen1Base = List.of(
                    Pokemon.builder().pokedexNumber(1).name("Bulbasaur").primaryType("Grass").secondaryType("Poison")
                            .height(0.7).weight(6.9)
                            .description("A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon.")
                            .build(),
                    Pokemon.builder().pokedexNumber(4).name("Charmander").primaryType("Fire").secondaryType(null)
                            .height(0.6).weight(8.5)
                            .description("Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.")
                            .build(),
                    Pokemon.builder().pokedexNumber(7).name("Squirtle").primaryType("Water").secondaryType(null)
                            .height(0.5).weight(9.0)
                            .description("After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.")
                            .build(),
                    Pokemon.builder().pokedexNumber(10).name("Caterpie").primaryType("Bug").secondaryType(null)
                            .height(0.3).weight(2.9)
                            .description("Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls.")
                            .build(),
                    Pokemon.builder().pokedexNumber(13).name("Weedle").primaryType("Bug").secondaryType("Poison")
                            .height(0.3).weight(3.2)
                            .description("Often found in forests, eating leaves. It has a sharp venomous stinger on its head.")
                            .build(),
                    Pokemon.builder().pokedexNumber(16).name("Pidgey").primaryType("Normal").secondaryType("Flying")
                            .height(0.3).weight(1.8)
                            .description("A common sight in forests and woods. It flaps its wings at ground level to kick up blinding sand.")
                            .build(),
                    Pokemon.builder().pokedexNumber(19).name("Rattata").primaryType("Normal").secondaryType(null)
                            .height(0.3).weight(3.5)
                            .description("Bites anything when it attacks. Small and very quick, it is a common sight in many places.")
                            .build(),
                    Pokemon.builder().pokedexNumber(21).name("Spearow").primaryType("Normal").secondaryType("Flying")
                            .height(0.3).weight(2.0)
                            .description("Eats bugs in grassy areas. It has to flap its short wings at high speed to stay airborne.")
                            .build(),
                    Pokemon.builder().pokedexNumber(23).name("Ekans").primaryType("Poison").secondaryType(null)
                            .height(2.0).weight(6.9)
                            .description("Moves silently and stealthily. Eats the eggs of birds, such as Pidgey and Spearow, whole.")
                            .build(),
                    Pokemon.builder().pokedexNumber(25).name("Pikachu").primaryType("Electric").secondaryType(null)
                            .height(0.4).weight(6.0)
                            .description("When several of these Pokémon gather, their electricity could build and cause lightning storms.")
                            .build(),
                    Pokemon.builder().pokedexNumber(27).name("Sandshrew").primaryType("Ground").secondaryType(null)
                            .height(0.6).weight(12.0)
                            .description("Burrows deep underground in arid locations far from water. It only emerges to hunt for food.")
                            .build(),
                    Pokemon.builder().pokedexNumber(29).name("Nidoran\u2640").primaryType("Poison").secondaryType(null)
                            .height(0.4).weight(7.0)
                            .description("Although small, its venomous barbs render this Pokémon dangerous. The female has smaller horns.")
                            .build(),
                    Pokemon.builder().pokedexNumber(32).name("Nidoran\u2642").primaryType("Poison").secondaryType(null)
                            .height(0.5).weight(9.0)
                            .description("Stiffens its ears to sense danger. The larger its horns, the more powerful its secreted venom.")
                            .build(),
                    Pokemon.builder().pokedexNumber(35).name("Clefairy").primaryType("Fairy").secondaryType(null)
                            .height(0.6).weight(7.5)
                            .description("Its magical and cute appeal has many admirers. It is rare and found only in certain areas.")
                            .build(),
                    Pokemon.builder().pokedexNumber(37).name("Vulpix").primaryType("Fire").secondaryType(null)
                            .height(0.6).weight(9.9)
                            .description("At the time of its birth, it has only one snowy-white tail. The tail splits from its tip as it grows older.")
                            .build(),
                    Pokemon.builder().pokedexNumber(39).name("Jigglypuff").primaryType("Normal").secondaryType("Fairy")
                            .height(0.5).weight(5.5)
                            .description("When it opens its large eyes, it sings a mysteriously soothing melody that lulls its enemies to sleep.")
                            .build(),
                    Pokemon.builder().pokedexNumber(41).name("Zubat").primaryType("Poison").secondaryType("Flying")
                            .height(0.8).weight(7.5)
                            .description("Forms colonies in perpetually dark places. Uses ultrasonic waves to identify and approach targets.")
                            .build(),
                    Pokemon.builder().pokedexNumber(43).name("Oddish").primaryType("Grass").secondaryType("Poison")
                            .height(0.5).weight(5.4)
                            .description("During the day, it keeps its face buried in the ground. At night, it wanders around sowing its seeds.")
                            .build(),
                    Pokemon.builder().pokedexNumber(46).name("Paras").primaryType("Bug").secondaryType("Grass")
                            .height(0.3).weight(5.4)
                            .description("Burrows to suck tree roots. The mushrooms on its back grow by drawing nutrients from the host insect.")
                            .build(),
                    Pokemon.builder().pokedexNumber(48).name("Venonat").primaryType("Bug").secondaryType("Poison")
                            .height(1.0).weight(30.0)
                            .description("Lives in the shadows of tall trees where it eats insects. It is attracted by light at night.")
                            .build(),
                    Pokemon.builder().pokedexNumber(50).name("Diglett").primaryType("Ground").secondaryType(null)
                            .height(0.2).weight(0.8)
                            .description("Lives about one yard underground where it feeds on plant roots. It sometimes appears above ground.")
                            .build(),
                    Pokemon.builder().pokedexNumber(52).name("Meowth").primaryType("Normal").secondaryType(null)
                            .height(0.4).weight(4.2)
                            .description("Adores round objects. Wanders the streets on a nightly basis to look for dropped loose change.")
                            .build(),
                    Pokemon.builder().pokedexNumber(54).name("Psyduck").primaryType("Water").secondaryType(null)
                            .height(0.8).weight(19.6)
                            .description("While lulling its enemies with its vacant look, this wily Pokémon will use psychokinetic powers.")
                            .build(),
                    Pokemon.builder().pokedexNumber(56).name("Mankey").primaryType("Fighting").secondaryType(null)
                            .height(0.5).weight(28.0)
                            .description("Extremely quick to anger. It could be docile one moment then thrashing away the next instant.")
                            .build(),
                    Pokemon.builder().pokedexNumber(58).name("Growlithe").primaryType("Fire").secondaryType(null)
                            .height(0.7).weight(19.0)
                            .description("Very protective of its territory. It will bark and bite to repel intruders from its space.")
                            .build(),
                    Pokemon.builder().pokedexNumber(60).name("Poliwag").primaryType("Water").secondaryType(null)
                            .height(0.6).weight(12.4)
                            .description("Its newly grown legs are frail, so it can't walk well. It seems to prefer swimming in water.")
                            .build(),
                    Pokemon.builder().pokedexNumber(63).name("Abra").primaryType("Psychic").secondaryType(null)
                            .height(0.9).weight(19.5)
                            .description("Using its ability to read minds, it will identify impending danger and Teleport to safety.")
                            .build(),
                    Pokemon.builder().pokedexNumber(66).name("Machop").primaryType("Fighting").secondaryType(null)
                            .height(0.8).weight(19.5)
                            .description("Loves to build its muscles. It trains in all styles of martial arts to become even stronger.")
                            .build(),
                    Pokemon.builder().pokedexNumber(69).name("Bellsprout").primaryType("Grass").secondaryType("Poison")
                            .height(0.7).weight(4.0)
                            .description("A carnivorous Pokémon that traps and eats bugs. It uses its root feet to soak up needed moisture.")
                            .build(),
                    Pokemon.builder().pokedexNumber(72).name("Tentacool").primaryType("Water").secondaryType("Poison")
                            .height(0.9).weight(45.5)
                            .description("Drifts in shallow seas. Anglers who hook them by accident are often punished by its stinging acid.")
                            .build(),
                    Pokemon.builder().pokedexNumber(74).name("Geodude").primaryType("Rock").secondaryType("Ground")
                            .height(0.4).weight(20.0)
                            .description("Found in fields and mountains. Mistaking them for boulders, people often step on them or trip over them.")
                            .build(),
                    Pokemon.builder().pokedexNumber(77).name("Ponyta").primaryType("Fire").secondaryType(null)
                            .height(1.0).weight(30.0)
                            .description("Its hooves are 10 times harder than diamonds. It can trample anything completely flat in little time.")
                            .build(),
                    Pokemon.builder().pokedexNumber(79).name("Slowpoke").primaryType("Water").secondaryType("Psychic")
                            .height(1.2).weight(36.0)
                            .description("Incredibly slow and dopey. It takes 5 seconds for it to feel pain when under attack.")
                            .build(),
                    Pokemon.builder().pokedexNumber(81).name("Magnemite").primaryType("Electric").secondaryType("Steel")
                            .height(0.3).weight(6.0)
                            .description("Uses anti-gravity to stay suspended. Appears without warning and uses Thunder Wave and others.")
                            .build(),
                    Pokemon.builder().pokedexNumber(83).name("Farfetch'd").primaryType("Normal").secondaryType("Flying")
                            .height(0.8).weight(15.0)
                            .description("The sprig of green onions it holds is its weapon. It is used much like a metal sword.")
                            .build(),
                    Pokemon.builder().pokedexNumber(84).name("Doduo").primaryType("Normal").secondaryType("Flying")
                            .height(1.4).weight(39.2)
                            .description("A bird that makes up for its poor flying with its fast foot speed. Leaves giant footprints.")
                            .build(),
                    Pokemon.builder().pokedexNumber(86).name("Seel").primaryType("Water").secondaryType(null)
                            .height(1.1).weight(90.0)
                            .description("The protruding horn on its head is very hard. It is used for bashing through thick ice.")
                            .build(),
                    Pokemon.builder().pokedexNumber(88).name("Grimer").primaryType("Poison").secondaryType(null)
                            .height(0.9).weight(30.0)
                            .description("Appears in filthy areas. Thrives by sucking up polluted sludge that is pumped out of factories.")
                            .build(),
                    Pokemon.builder().pokedexNumber(90).name("Shellder").primaryType("Water").secondaryType(null)
                            .height(0.3).weight(4.0)
                            .description("Its hard shell repels any kind of attack. It is vulnerable only when its shell is open.")
                            .build(),
                    Pokemon.builder().pokedexNumber(92).name("Gastly").primaryType("Ghost").secondaryType("Poison")
                            .height(1.3).weight(0.1)
                            .description("Almost invisible, this gaseous Pokémon cloaks the target and puts it to sleep without notice.")
                            .build(),
                    Pokemon.builder().pokedexNumber(95).name("Onix").primaryType("Rock").secondaryType("Ground")
                            .height(8.8).weight(210.0)
                            .description("As it grows, the stone portions of its body harden to become similar to a diamond, but colored black.")
                            .build(),
                    Pokemon.builder().pokedexNumber(96).name("Drowzee").primaryType("Psychic").secondaryType(null)
                            .height(1.0).weight(32.4)
                            .description("Puts enemies to sleep then eats their dreams. Occasionally gets sick from eating bad dreams.")
                            .build(),
                    Pokemon.builder().pokedexNumber(98).name("Krabby").primaryType("Water").secondaryType(null)
                            .height(0.4).weight(6.5)
                            .description("Its pincers are not only powerful weapons, they are used for balance when walking sideways.")
                            .build(),
                    Pokemon.builder().pokedexNumber(100).name("Voltorb").primaryType("Electric").secondaryType(null)
                            .height(0.5).weight(10.4)
                            .description("It was discovered when Poké Balls were introduced. It is said that there is some connection.")
                            .build(),
                    Pokemon.builder().pokedexNumber(102).name("Exeggcute").primaryType("Grass").secondaryType("Psychic")
                            .height(0.4).weight(2.5)
                            .description("Often mistaken for eggs. When disturbed, they quickly gather and attack in swarms.")
                            .build(),
                    Pokemon.builder().pokedexNumber(104).name("Cubone").primaryType("Ground").secondaryType(null)
                            .height(0.4).weight(6.5)
                            .description("Because it never removes its skull helmet, no one has ever seen this Pokémon's real face.")
                            .build(),
                    Pokemon.builder().pokedexNumber(106).name("Hitmonlee").primaryType("Fighting").secondaryType(null)
                            .height(1.5).weight(49.8)
                            .description("When in a hurry, its legs magically stretch. It runs with over-long, galloping strides.")
                            .build(),
                    Pokemon.builder().pokedexNumber(107).name("Hitmonchan").primaryType("Fighting").secondaryType(null)
                            .height(1.4).weight(50.2)
                            .description("While appearing to do nothing, it fires punch after punch so fast, they are impossible to see.")
                            .build(),
                    Pokemon.builder().pokedexNumber(108).name("Lickitung").primaryType("Normal").secondaryType(null)
                            .height(1.2).weight(65.5)
                            .description("Its tongue can be extended like a chameleon's. It leaves a tingling sensation when it licks enemies.")
                            .build(),
                    Pokemon.builder().pokedexNumber(109).name("Koffing").primaryType("Poison").secondaryType(null)
                            .height(0.6).weight(1.0)
                            .description("Because it stores several kinds of toxic gases in its body, it is prone to exploding without warning.")
                            .build(),
                    Pokemon.builder().pokedexNumber(111).name("Rhyhorn").primaryType("Ground").secondaryType("Rock")
                            .height(1.0).weight(115.0)
                            .description("Its massive bones are 1000 times harder than human bones. It can easily knock a trailer trailer over.")
                            .build(),
                    Pokemon.builder().pokedexNumber(113).name("Chansey").primaryType("Normal").secondaryType(null)
                            .height(1.1).weight(34.6)
                            .description("A rare and elusive Pokémon that is said to bring happiness to those who manage to get it.")
                            .build(),
                    Pokemon.builder().pokedexNumber(114).name("Tangela").primaryType("Grass").secondaryType(null)
                            .height(1.0).weight(35.0)
                            .description("The whole body is swathed with wide vines that are similar to seaweed. Its vines shake as it walks.")
                            .build(),
                    Pokemon.builder().pokedexNumber(115).name("Kangaskhan").primaryType("Normal").secondaryType(null)
                            .height(2.2).weight(80.0)
                            .description("The infant rarely ventures out of its mother's protective pouch until it is 3 years old.")
                            .build(),
                    Pokemon.builder().pokedexNumber(116).name("Horsea").primaryType("Water").secondaryType(null)
                            .height(0.4).weight(8.0)
                            .description("Known to shoot down flying bugs with precision blasts of ink from the surface of the water.")
                            .build(),
                    Pokemon.builder().pokedexNumber(118).name("Goldeen").primaryType("Water").secondaryType(null)
                            .height(0.6).weight(15.0)
                            .description("Its tail fin billows like an elegant ballroom dress, giving it the nickname of the Water Queen.")
                            .build(),
                    Pokemon.builder().pokedexNumber(120).name("Staryu").primaryType("Water").secondaryType(null)
                            .height(0.8).weight(34.5)
                            .description("An enigmatic Pokémon that can effortlessly regenerate any appendage it loses in battle.")
                            .build(),
                    Pokemon.builder().pokedexNumber(122).name("Mr. Mime").primaryType("Psychic").secondaryType("Fairy")
                            .height(1.3).weight(54.5)
                            .description("If interrupted while it is miming, it will suddenly slap the offender with its broad hands.")
                            .build(),
                    Pokemon.builder().pokedexNumber(123).name("Scyther").primaryType("Bug").secondaryType("Flying")
                            .height(1.5).weight(56.0)
                            .description("With ninja-like agility and speed, it can create the illusion that there is more than one.")
                            .build(),
                    Pokemon.builder().pokedexNumber(124).name("Jynx").primaryType("Ice").secondaryType("Psychic")
                            .height(1.4).weight(40.6)
                            .description("It seductively wiggles its hips as it walks. It can cause people to dance in unison with it.")
                            .build(),
                    Pokemon.builder().pokedexNumber(125).name("Electabuzz").primaryType("Electric").secondaryType(null)
                            .height(1.1).weight(30.0)
                            .description("Normally found near power plants, they can wander away and cause major blackouts in cities.")
                            .build(),
                    Pokemon.builder().pokedexNumber(126).name("Magmar").primaryType("Fire").secondaryType(null)
                            .height(1.3).weight(44.5)
                            .description("Its body always burns with an orange glow that enables it to hide perfectly among flames.")
                            .build(),
                    Pokemon.builder().pokedexNumber(127).name("Pinsir").primaryType("Bug").secondaryType(null)
                            .height(1.5).weight(55.0)
                            .description("If it fails to crush the victim in its pincers, it will swing it around and toss it hard.")
                            .build(),
                    Pokemon.builder().pokedexNumber(128).name("Tauros").primaryType("Normal").secondaryType(null)
                            .height(1.4).weight(88.4)
                            .description("When it targets an enemy, it charges headlong while whipping its body with its three long tails.")
                            .build(),
                    Pokemon.builder().pokedexNumber(129).name("Magikarp").primaryType("Water").secondaryType(null)
                            .height(0.9).weight(10.0)
                            .description("In the distant past, it was somewhat stronger than the horribly weak descendants that exist today.")
                            .build(),
                    Pokemon.builder().pokedexNumber(131).name("Lapras").primaryType("Water").secondaryType("Ice")
                            .height(2.5).weight(220.0)
                            .description("A gentle soul that can understand human speech. It can ferry people across the sea on its back.")
                            .build(),
                    Pokemon.builder().pokedexNumber(132).name("Ditto").primaryType("Normal").secondaryType(null)
                            .height(0.3).weight(4.0)
                            .description("Capable of copying an enemy's genetic code to instantly transform itself into a duplicate of the enemy.")
                            .build(),
                    Pokemon.builder().pokedexNumber(133).name("Eevee").primaryType("Normal").secondaryType(null)
                            .height(0.3).weight(6.5)
                            .description("Its genetic code is irregular. It may mutate if it is exposed to radiation from element Stones.")
                            .build(),
                    Pokemon.builder().pokedexNumber(137).name("Porygon").primaryType("Normal").secondaryType(null)
                            .height(0.8).weight(36.5)
                            .description("A Pokémon that consists entirely of programming code. Capable of moving freely in cyberspace.")
                            .build(),
                    Pokemon.builder().pokedexNumber(138).name("Omanyte").primaryType("Rock").secondaryType("Water")
                            .height(0.4).weight(7.5)
                            .description("An ancient Pokémon that was resurrected from a fossil. It swims by twisting its 10 tentacles.")
                            .build(),
                    Pokemon.builder().pokedexNumber(140).name("Kabuto").primaryType("Rock").secondaryType("Water")
                            .height(0.5).weight(11.5)
                            .description("A Pokémon that was resurrected from a fossil found in what was once the ocean floor eons ago.")
                            .build(),
                    Pokemon.builder().pokedexNumber(142).name("Aerodactyl").primaryType("Rock").secondaryType("Flying")
                            .height(1.8).weight(59.0)
                            .description("A ferocious, prehistoric Pokémon that goes for the enemy's throat with its serrated saw-like teeth.")
                            .build(),
                    Pokemon.builder().pokedexNumber(143).name("Snorlax").primaryType("Normal").secondaryType(null)
                            .height(2.1).weight(460.0)
                            .description("Very lazy. Just eats and sleeps. As its rotund bulk builds, it becomes steadily more slothful.")
                            .build(),
                    Pokemon.builder().pokedexNumber(144).name("Articuno").primaryType("Ice").secondaryType("Flying")
                            .height(1.7).weight(55.4)
                            .description("A legendary bird Pokémon that is said to appear to doomed people who are lost in icy mountains.")
                            .build(),
                    Pokemon.builder().pokedexNumber(145).name("Zapdos").primaryType("Electric").secondaryType("Flying")
                            .height(1.6).weight(52.6)
                            .description("A legendary bird Pokémon that is said to appear from clouds while wielding enormous lightning bolts.")
                            .build(),
                    Pokemon.builder().pokedexNumber(146).name("Moltres").primaryType("Fire").secondaryType("Flying")
                            .height(2.0).weight(60.0)
                            .description("Known as the legendary bird of fire. Every flap of its wings creates a dazzling flash of flames.")
                            .build(),
                    Pokemon.builder().pokedexNumber(147).name("Dratini").primaryType("Dragon").secondaryType(null)
                            .height(1.8).weight(3.3)
                            .description("Long considered a mythical Pokémon until recently, when a small colony was found living underwater.")
                            .build(),
                    Pokemon.builder().pokedexNumber(150).name("Mewtwo").primaryType("Psychic").secondaryType(null)
                            .height(2.0).weight(122.0)
                            .description("It was created by a scientist after years of horrific gene-splicing and DNA-engineering experiments.")
                            .build(),
                    Pokemon.builder().pokedexNumber(151).name("Mew").primaryType("Psychic").secondaryType(null)
                            .height(0.4).weight(4.0)
                            .description("So rare that it is still said to be a mirage by many experts. Only a few people have seen it worldwide.")
                            .build());
            pokemonRepository.saveAll(gen1Base);
            System.out.println("✅ Pokédex seeded with " + gen1Base.size() + " base form Pokémon!");
        }
    }
}
