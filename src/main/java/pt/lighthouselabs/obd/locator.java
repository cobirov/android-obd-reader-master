package pt.lighthouselabs.obd;

import android.os.Environment;
import android.util.Log;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


/**
 * Created  on 26.05.2015.
 */
public class locator {
    final String LOG_TAG = "myLogs";
    final String DIR_SD = "MyFiles";
    final String FILENAME_SD = "SpeedCam";

    public List<String[]> allRows;

    locator(){
        readFileSD();
    }

    public void readFileSD() {
        // проверяем доступность SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(sdPath, FILENAME_SD);
        try {

            example001ParseAll();

            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new FileReader(sdFile));
            String str = "";
            // читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> example001ParseAll() throws FileNotFoundException {
        CsvParserSettings settings = new CsvParserSettings();
        //settings.selectFields("Price", "Year", "Make");
        settings.getFormat().setLineSeparator("\n");
        //settings.selectIndexes(4, 0, 1);
        CsvParser parser = new CsvParser(settings);
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD + "/" + FILENAME_SD);
        String pathss = sdPath.getAbsolutePath();
        Log.d(LOG_TAG, pathss);

        // List<String[]> allRows = parser.parseAll(getReader(pathss));

         allRows = parser.parseAll(new FileReader(pathss));



        return allRows;
        //Log.d(LOG_TAG, pathss);
        //Log.d(LOG_TAG, allRows);
        //  printAndValidate(null, allRows);


    }


    public List<String[]> vozr()
    {
        return allRows;

    }

}
