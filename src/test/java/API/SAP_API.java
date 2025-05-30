package API;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pojo.HeaderModel;
import pojo.ItemInfoSTO;
import pojo.ItemInfoSale;
import pojo.ItemModel;
import pojo.PostPickList;
import pojo.STO;
import pojo.Sales;

public class SAP_API {

	utils.RandomGenerator ran = new utils.RandomGenerator();

	public List<STO> stoPayloadBody() {

		List<STO> abc = new ArrayList<>();
		STO sto = new STO();

		sto.setDelvOrdNo(ran.randomNumber(10));
		sto.setSupLocCode("5400");
		sto.setRecLocCode("5200");
		sto.setDelvDate(LocalDate.now().toString());
		ItemInfoSTO info = new ItemInfoSTO();
		info.setItemNo(1);
		info.setProdCode("1234567");
		info.setPlanQty(6);
		List<ItemInfoSTO> data = new ArrayList<>();
		data.add(info);
		sto.setItemInfo(data);

		abc.add(sto);
		return abc;

	}

	public List<Sales> getSalesPayload() {

		Sales sale = new Sales();
		sale.setInvoiceType("SALES");
		sale.setInvSubType("F2");
		sale.setDelvOrdNo(ran.randomNumber(10));
		sale.setSupLocCode("5400");
		sale.setRecLocCode("0000101968");
		sale.setInvDate(LocalDate.now().toString());
		sale.setInvNo(ran.randomNumber(10));
		sale.setRefInvNo("");

		List<ItemInfoSale> itemInfoList = new ArrayList<>();
		ItemInfoSale item = new ItemInfoSale();
		item.setDelvItemNo(1);
		item.setProdCode("7245829");
		item.setInvQty(5);
		item.setAumId("CS");
		item.setMrpBatch("25D01");
		item.setProdSloc("QR01");

		itemInfoList.add(item);
		sale.setItemInfo(itemInfoList);

		List<Sales> salesList = new ArrayList<>();
		salesList.add(sale);
		return salesList;

	}
	
	public List<Sales> cancelSalesPayload() {

		Sales sale = new Sales();
		sale.setInvoiceType("SALES");
		sale.setInvSubType("RE");
		sale.setDelvOrdNo(ran.randomNumber(10));
		sale.setSupLocCode("5400");
		sale.setRecLocCode("0000101968");
		sale.setInvDate(LocalDate.now().toString());
		sale.setInvNo(ran.randomNumber(10));
		sale.setRefInvNo("");

		List<ItemInfoSale> itemInfoList = new ArrayList<>();
		ItemInfoSale item = new ItemInfoSale();
		item.setDelvItemNo(1);
		item.setProdCode("7245829");
		item.setInvQty(5);
		item.setAumId("CS");
		item.setMrpBatch("25D01");
		item.setProdSloc("QR01");

		itemInfoList.add(item);
		sale.setItemInfo(itemInfoList);

		List<Sales> salesList = new ArrayList<>();
		salesList.add(sale);
		return salesList;

	}

	public PostPickList postPickListPayload() {

		PostPickList ppl = new PostPickList();

		HeaderModel hm = new HeaderModel();
		hm.setTripNo("0624-5200-65020");
		hm.setSupLocCode("5300");
		hm.setRecLocCode("5400");
		hm.setLoadDate(LocalDate.now().toString());
		hm.setVehicleNo("TestVehicle");
		hm.setTruckNo("TestTruck");
		hm.setSealNo("TestSeal");

		ItemModel im = new ItemModel();
		im.setDelvOrdNo(ran.randomNumber(10));
		im.setDelvStat("");
		im.setItemNo("000001");
		im.setProdCode("7346423");
		im.setLoadQty(3);
		im.setMrpBatch("25F13");
		im.setProdSloc("QR01");

		List<ItemModel> listItem = new ArrayList<>();
		listItem.add(im);

		ppl.setHeader(hm);
		ppl.setItem(listItem);

		return ppl;

	}

}
