using System.Collections.Generic;

namespace MyFirstWebApplication.Models
{

    /// <summary>
    /// Объект хранит список показаний температуры
    /// </summary>
    public class WeatherForecastModel
    {
        // Коллекция для хранения показателей температуры
        private List<WeatherForecast> _list;


        public WeatherForecastModel()
        {
            _list = new List<WeatherForecast>();
        }

        public void Add(DateTime date, int temperatureC)
        {
            WeatherForecast weatherForecast = new WeatherForecast(date, temperatureC);
            _list.Add(weatherForecast);
        }

        public void Update(DateTime date, int temperatureC)
        {
            foreach (WeatherForecast weatherForecast in _list)
            {
                if (weatherForecast.Date== date){
                    weatherForecast.TemperatureC = temperatureC;
                    break;
                }
            }
        }

        public List<WeatherForecast> GetAll(DateTime dateFrom, DateTime dateTo)
        {
            List<WeatherForecast> listByDate = new List<WeatherForecast>();

            foreach (WeatherForecast weatherForecast in _list)
            {
                if (weatherForecast.Date >= dateFrom && weatherForecast.Date <= dateTo)
                {
                    listByDate.Add(weatherForecast);
                }
            }
            return listByDate;
        }

        public void Delete(DateTime date)
        {
           
            //TODO: Домашняя работа, доработать метод Delete
        }



    }
}
