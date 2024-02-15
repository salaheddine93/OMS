package org.bs.oms;

import org.bs.oms.entities.*;
import org.bs.oms.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class OmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	CommandLineRunner start(AirbaseRepo airbaseRepo, PlaceRepo placeRepo, ParkingRepo parkingRepo, SquadronRepo squadronRepo,
							AircraftMakerRepo aircraftMakerRepo, VersionRepo versionRepo, AircraftRepo aircraftRepo, DailySituationRepo dailySituationRepo){
		return args -> {

			// AirBases Creation
			/*Stream.of("DUKHAN AIRBASE","ODEID AIRBASE","DOHA AIRBASE")
					.forEach(a->{
						Airbase airBase = new Airbase();
						airBase.setName(a);
						String[] cit = a.split(" ");
						airBase.setCity(cit[0]);
						airBase.setLatitude("40.714");
						airBase.setLongitude("-74.006");
						airBase.setSurface("50 Ha");
						airBase.setCreationDate(new Date());
						airbaseRepo.save(airBase);
					});
*/


			Airbase airbase1 = new Airbase();
			airbase1.setName("DUKHAN AIRBASE");
			airbase1.setCity("DUKHAN");
			airbase1.setLatitude("40.714");
			airbase1.setLongitude("-74.006");
			airbase1.setSurface("50 Ha");
			airbase1.setCreationDate(new Date());
			airbaseRepo.save(airbase1);

			Airbase airbase2 = new Airbase();
			airbase2.setName("DOHA AIRBASE");
			airbase2.setCity("DOHA");
			airbase2.setLatitude("40.714");
			airbase2.setLongitude("-74.006");
			airbase2.setSurface("50 Ha");
			airbase2.setCreationDate(new Date());
			airbaseRepo.save(airbase2);

			Airbase airbase3 = new Airbase();
			airbase3.setName("ODEID AIRBASE");
			airbase3.setCity("ODEID");
			airbase3.setLatitude("40.714");
			airbase3.setLongitude("-74.006");
			airbase3.setSurface("50 Ha");
			airbase3.setCreationDate(new Date());
			airbaseRepo.save(airbase3);

			Airbase airbase4 = new Airbase();
			airbase4.setName("MARINES AIRBASE");
			airbase4.setCity("NASSRANIA");
			airbase4.setLatitude("40.714");
			airbase4.setLongitude("-74.006");
			airbase4.setSurface("50 Ha");
			airbase4.setCreationDate(new Date());
			airbaseRepo.save(airbase4);

			Airbase airbase5 = new Airbase();
			airbase5.setName("POLICE AIRBASE");
			airbase5.setCity("ASSAD");
			airbase5.setLatitude("40.714");
			airbase5.setLongitude("-74.006");
			airbase5.setSurface("50 Ha");
			airbase5.setCreationDate(new Date());
			airbaseRepo.save(airbase5);

			Airbase airbase6 = new Airbase();
			airbase6.setName("ARMORY AIRBASE");
			airbase6.setCity("JAMILIA");
			airbase6.setLatitude("40.714");
			airbase6.setLongitude("-74.006");
			airbase6.setSurface("50 Ha");
			airbase6.setCreationDate(new Date());
			airbaseRepo.save(airbase6);

			Airbase airbase7 = new Airbase();
			airbase7.setName("KHUIA AIRBASE");
			airbase7.setCity("OUAKRA");
			airbase7.setLatitude("40.714");
			airbase7.setLongitude("-74.006");
			airbase7.setSurface("50 Ha");
			airbase7.setCreationDate(new Date());
			airbaseRepo.save(airbase7);





			// Places Creation
			for (int i=1; i<=7; i++){
				Place place  = new Place();
				place.setName("F"+i);
				//place.setStatus(i % 2 == 0 ? true : false);
				place.setStatus(true);
				placeRepo.save(place);
			}
			for (int i=1; i<=7; i++){
				Place place  = new Place();
				place.setName("S"+i);
				//place.setStatus(i % 2 == 0 ? true : false);
				place.setStatus(true);
				placeRepo.save(place);
			}

			// Parking Creation
			Stream.of("Parking A","Parking B")
					.forEach(i->{
						Parking parking = new Parking();
						parking.setName(i);
						parking.setColor("Orange");
						parkingRepo.save(parking);
					});

			// Adding Places to Parking
			Parking parkingA = parkingRepo.findById(1L).get();
			Parking parkingB = parkingRepo.findById(2L).get();
			List<Place> placesF = placeRepo.findByNameContaining("F");
			List<Place> placesS = placeRepo.findByNameContaining("S");
			parkingA.setPlaces(placesF);
			parkingRepo.save(parkingA);
			parkingB.setPlaces(placesS);
			parkingRepo.save(parkingB);

			// Adding Parking to Airbases
			Airbase dukhanAirbase = airbaseRepo.findById(1L).get();
			Airbase dohaAirbase = airbaseRepo.findById(3L).get();
			List<Parking> parkingList =parkingRepo.findAll();
			dukhanAirbase.setParking(parkingList);
			dohaAirbase.setParking(parkingList);
			airbaseRepo.save(dukhanAirbase);
			//airbaseRepo.save(dohaAirbase);
/*
			// Squadrons Creation
			Stream.of("1st SQUADRON","7th SQUADRON","15th SQUADRON","52nd SQUADRON")
					.forEach(a->{
						Squadron squadron  = new Squadron();
						squadron.setName(a);
						squadron.setAirbase(airbaseRepo.findById(1L).get());
						squadron.setCreationDate(new Date());
						squadron.setAircraftType("TYPHON");
						squadron.setTotalAircraft("36");
						squadron.setDescription("Squadron Description !!!!!");
						squadronRepo.save(squadron);
					});

			// Versions Creation
			Stream.of("RAFALE C","RAFALE B","RAFALE M","TYPHON T1","TYPHON T2","TYPHON T3")
					.forEach(i->{
						Version version = new Version();
						version.setVersion(i);
						version.setDate(new Date());
						versionRepo.save(version);
					});

			// AircraftMakers Creation
			Stream.of("TYPHON","RAFALE","APACHE","F15 EAGLE")
					.forEach(a->{
						AircraftMaker aircraftMaker = new AircraftMaker();
						aircraftMaker.setName(a);
						aircraftMaker.setAirForce(true);
						aircraftMakerRepo.save(aircraftMaker);
					});

			//Adding versions to aircraftMakers
			AircraftMaker typhonAircraftMaker = aircraftMakerRepo.findById(1L).get();
			List<Version> typhonVersions = versionRepo.findByVersionContaining("TYPHON");
			typhonAircraftMaker.setVersions(typhonVersions);
			aircraftMakerRepo.save(typhonAircraftMaker);
			AircraftMaker rafaleAircraftMaker = aircraftMakerRepo.findById(2L).get();
			List<Version> rafaleVersions = versionRepo.findByVersionContaining("RAFALE");
			rafaleAircraftMaker.setVersions(rafaleVersions);
			aircraftMakerRepo.save(rafaleAircraftMaker);

			// Aircraft Creation
			Aircraft aircraft = new Aircraft();
			aircraft.setName("Typhon");
			aircraft.setInterNumber("QA93");
			AircraftMaker maker = aircraftMakerRepo.findById(1L).get();
			aircraft.setAircraftMaker(maker);
			aircraft.setVersion(maker.getVersions().get(0));
			aircraft.setStatus(AircraftStatus.IN_SERVICE);
			aircraft.setAirbase(airbaseRepo.findById(1L).get());
			aircraft.setSquadron(squadronRepo.findById(1L).get());
			aircraftRepo.save(aircraft);

			// DailySituation testing
			DailySituation dailySituation = new DailySituation();
			Place place = placeRepo.findById(8L).get();
			Aircraft airplane = aircraftRepo.findById(1L).get();
			dailySituation.setAircraft(airplane);
			dailySituation.setPlace(place);
			dailySituation.setDate(new Date());
			dailySituationRepo.save(dailySituation);




			//***************
//			Airbase airbase = new Airbase();
//			airbase.setName("Test");
//			airbaseRepo.save(airbase);

			 */

		};
	}

}
