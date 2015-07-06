package pt.lighthouselabs.obd;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.location.*;
import android.content.Context;
import pt.lighthouselabs.obd.reader.activity.MainActivity;


import java.util.List;

public class DistanceActivity  implements  LocationListener
{




	TextView cordd1;
	TextView cordd2;
    TextView cordd3;
	public boolean bStarted = false;
	TextView textView1;
	Button button1;
	Location first, second;
	LocationManager locationManager;
	locator hlut;
	locator m = new locator ();
	private List<String[]> allRowss;
	private Double d1;
	private Double d2;
	//locationManager = Context.LOCATION_SERVICE;

	//
	//locationManager = (LocationManager) (Context.LOCATION_SERVICE);
	public DistanceActivity(TextView cordd1, TextView cordd2, TextView cordd3, LocationManager locationManager){
	this.cordd1=cordd1;
	this.cordd2=cordd2;
    this.cordd3= cordd3;
	this.locationManager=locationManager;

     }

	//public DistanceActivity(TextView compass) {

	//}


	public void onPkaz ()
	{



		if (bStarted)
        {

			if (first  !=null)
			{
			// Отказаться от обновлений локации
			//locationManager.removeUpdates(this);
			second = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

			//button1.setText(R.string.start);


			bStarted = false;
			//znach = hlut.readFileSD();
			this.allRowss = m.allRows;
			String[] catNames = new String[10];
			//Double etal1 = Double.valueOf(first.getLatitude());
			//Double etal2 = Double.valueOf(first.getLongitude());
			Double etal1 = Double.valueOf(first.getLatitude());
			Double etal2 = Double.valueOf(first.getLongitude());
			double min = Math.abs(etal1 - 1);
			for (int i = 1; i < allRowss.size(); i++) {
				catNames = allRowss.get(i);


				try {
					d1 = new Double(catNames[0]);
					if (Math.abs(etal1 - d1) < min) {
						min = Math.abs(etal1 - d1);
					}
					;


					//System.out.println(d1);
				} catch (NumberFormatException e) {
					//System.err.println("Неверный формат строки!");
				}
			}

			double min2 = Math.abs(etal2 - 1);
			for (int i = 1; i < allRowss.size(); i++) {
				catNames = allRowss.get(i);


				try {
					d2 = new Double(catNames[1]);
					if (Math.abs(etal2 - d2) < min2) {
						min2 = Math.abs(etal1 - d2);
					}
					;


					//System.out.println(d1);
				} catch (NumberFormatException e) {
					//System.err.println("Неверный формат строки!");
				}
			}


			// Вывести координаты начала и конца, а также расстояние в TextView
			second.setLatitude(d2);
			second.setLongitude(d1);
			cordd2.setText("hyli");
			//==cordd2.setText("Начало: (" +
			//		Double.valueOf(first.getLatitude()).toString() + ", " +
			//		Double.valueOf(first.getLongitude()).toString() + ")" + "\n" +
			//		"Конец: (" +
			//		Double.valueOf(second.getLatitude()).toString() + ", " +
			//		Double.valueOf(second.getLongitude()).toString() + ")" + "\n" +
			//==		"Расстояние, м: " + Float.valueOf(first.distanceTo(second)).toString());
			cordd2.setText("Камера: (" +
					Double.valueOf(second.getLatitude()).toString() + ", " +
					Double.valueOf(second.getLongitude()).toString() + ")");
            cordd3.setText("Расстояние, м:" + Float.valueOf(first.distanceTo(second)).toString());
		}
        }
        else
        {
        	first = null;
        //	textView1.setText("");
        	
        	// Получать обновление локации
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            
        	//button1.setText(R.string.stop);
        	bStarted = true;
        }
	}
	
	public void onLocationChanged(Location location)
    {
    	if (first == null)
    	{
    		first = location;
    		second = location;
    		
    		// Вывести координаты в TextView
    		cordd1.setText("Начало222: (" +
					Double.valueOf(first.getLatitude()).toString() + ", " +
					Double.valueOf(first.getLongitude()).toString() + ")");
    	}
    }
	
	public void onStatusChanged(String provider, int status, Bundle extras) {}
    public void onProviderEnabled(String provider) {}
    public void onProviderDisabled(String provider) {}
	
	//@Override
    //public void onCreate(Bundle savedInstanceState)
   // {
        //super.onCreate(savedInstanceState);
      //  setContentView(R.layout.main);
        
      //  textView1 = (TextView)findViewById(R.id.textView1);
      //  button1 = (Button)findViewById(R.id.button1);
       // button1.setOnClickListener(this);
        
        // Получим ссылку на действующий Location Manager
        //locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
   // }
}