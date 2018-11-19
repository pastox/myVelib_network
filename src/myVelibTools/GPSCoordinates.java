package myVelibTools;

/**
 * This class describes a position with its GPS coordinates
 * 
 * @author Pasteau Jebbari
 *
 */
public class GPSCoordinates {
	
	private double latitude;
	private double longitude;
	
	/**
	 * This Constructor builds a set of GPS coordinates 
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public static void main(String[] args) {
		GPSCoordinates position1 = new GPSCoordinates(47.45376854,0.71693349);
		GPSCoordinates position2 = new GPSCoordinates(47.44431175,0.70717026);
		System.out.println(position1.distanceTo(position2));//==1.282);
	}
	public GPSCoordinates(double latitude, double longitude) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		
	}
	
	/**
	 * 
	 * This method gives the distance (in meters) from a position(given with its GPS coordinates) to the position of the object from which this method is being executed
	 * @param position
	 * @return
	 */
	public double distanceTo(GPSCoordinates position) {
		
		int R = 6378000; //Rayon de la terre en m�tre
				 
		double lat_a = Math.toRadians(this.latitude);
		double lon_a = Math.toRadians(this.longitude);
		double lat_b = Math.toRadians(position.getLatitude());
		double lon_b = Math.toRadians(position.getLongitude());
				     
		double d = R * (Math.PI/2 - Math.asin( Math.sin(lat_b) * Math.sin(lat_a) + Math.cos(lon_b - lon_a) * Math.cos(lat_b) * Math.cos(lat_a)));
		return d;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GPSCoordinates other = (GPSCoordinates) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
