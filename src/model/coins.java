// Raquel Olhovetchi Ferreira da Silva
// Sol Castilho Ara�jo de Moraes S�da
// Victor Nielsen Ribeirete

package model;

    class coins {
	public int qtt;
	public int value;
	
	public coins(int Qtt,int Value) {
		qtt=Qtt;
		value=Value;
	}
	
	//Retorna um valor de moeda 
	public int Get_value() {
		return value;
	}
}
