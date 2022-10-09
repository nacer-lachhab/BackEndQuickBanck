package backEndQuickBank.treadAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backEndQuickBank.treadAPI.model.Connection;
import backEndQuickBank.treadAPI.model.TreadHistoriqueValues;
import backEndQuickBank.treadAPI.util.TreadUtil;



@CrossOrigin
@RestController
@RequestMapping(path = "treading")
public class TreadingApiController {

	@GetMapping
	public  List<TreadUtil> getTreadHistorique(
			@RequestParam(name = "from") String dateD,
			@RequestParam(name = "to")String dateF) throws InterruptedException 
	{
		System.out.println("dedans *************");
		
		//les dates Required sous forme: "2020-11-23".
		String date=dateD;
		TreadHistoriqueValues values=new TreadHistoriqueValues();
		
		Connection connection = new Connection();
		
		int an= Integer.valueOf(date.substring(0,4));
		int anf= Integer.valueOf(dateF.substring(0,4));
		
		int mm= Integer.valueOf(date.substring(5,7));
		int mmf= Integer.valueOf(dateF.substring(5,7));
		
		int jj= Integer.valueOf(date.substring(8,10));
		int jjf= Integer.valueOf(dateF.substring(8,10));
		
		System.out.println("test0 "+values.getTreadValues().size());
		
//		TreadUtil t1 = connection.treadApiConnection(date);
//		
//		values.getTreadValues().add(t1);
//		System.out.println("test1 :"+values.getTreadValues().size());
//		System.out.println(values.getTreadValues().get(0).getValue());
//
//		if(mm<=9) {date=an+"-0"+mm+"-"+(jj+1);}
//		else date=an+"-"+mm+"-"+(jj+1);
//		System.out.println("*************************");
//		System.out.println("test2 la date2 est: "+date);
//		
//		t1 = connection.treadApiConnection(date);
//		System.out.println(t1);
//		values.getTreadValues().add(t1);
//		System.out.println("test1 :"+values.getTreadValues().size());
//		System.out.println("test1 :"+values.getTreadValues().size());
		
		
		
		//while(!date.equalsIgnoreCase(dateF)) {
			while(an<=anf && !date.equalsIgnoreCase(dateF)) {
				while (mm<=mmf && !date.equalsIgnoreCase(dateF)) {
					if(mm<mmf) {
						while (jj<=31 && !date.equalsIgnoreCase(dateF)) {
							TreadUtil v = connection.treadApiConnection(date);
							if(!v.equals(null))
							{
								values.getTreadValues().add(v);
								jj++;
								if(mm<=9){
									if(jj<=9)
										date=an+"-0"+mm+"-0"+jj;
									else 
										date=an+"-0"+mm+"-"+jj;
								}
								//mois a deux chiffres :mm>=10
								else {
									if(jj<=9)
										date=an+"-"+mm+"-0"+jj;
									else 
										date=an+"-"+mm+"-"+jj;
								}
							}
						}
						mm++;
						jj=1;
					}
					
					else if(mm==mmf) {
						while (jj<=jjf && !date.equalsIgnoreCase(dateF)) {
							if(jj<=9)
								date=an+"-0"+mm+"-0"+jj;
							TreadUtil v = connection.treadApiConnection(date);
							if(!v.equals(null))
							{
								values.getTreadValues().add(v);
								jj++;
								if(mm<=9){
									if(jj<=9)
										date=an+"-0"+mm+"-0"+jj;
									else 
										date=an+"-0"+mm+"-"+jj;
								}
								//mois a deux chiffres :mm>=10
								else {
									if(jj<=9)
										date=an+"-"+mm+"-0"+jj;
									else 
										date=an+"-"+mm+"-"+jj;
								}
							}
						}
						mm++;
					}
					
				}
				an++;
			}
		//}
		
		System.out.println("****fin****");
//		values.getTreadValues().stream().forEach(
//				v->System.out.println(
//						"a la date: "+v.getDate()
//						+" la valeur est"+" "+v.getValue()
//						));
		return values.getTreadValues();
		
	}//fin getTreadHistorique.
}
