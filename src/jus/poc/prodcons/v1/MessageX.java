package jus.poc.prodcons.v1;

import jus.poc.prodcons.Message;

public class MessageX implements Message {

	private int idProd;
	private int numMsg;
	private boolean pilule;

	public MessageX(int idProd, int numMsg, boolean pilule) {
		this.idProd = idProd;
		this.numMsg = numMsg;
		this.pilule = pilule;
	}

	public String toString()
	{
		return "(IDmsg : "+numMsg+", IDprod : "+idProd + " pilule :"+ pilule +")";


	}


}
