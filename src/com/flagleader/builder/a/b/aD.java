package com.flagleader.builder.a.b;

import com.flagleader.soap.ISoap;
import java.util.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class aD
  implements Runnable
{
  aD(aB paramaB, ISoap paramISoap)
  {
  }

  public void run()
  {
    if (this.b == null)
      return;
    for (int i = 0; i < aB.d(this.a).getItemCount(); i++)
    {
      TableItem localTableItem = aB.d(this.a).getItems()[i];
      localTableItem.setData(null);
      localTableItem.setText(3, "");
      String str1 = localTableItem.getText(4);
      Object localObject = this.b.getObject(str1);
      if (str1.equalsIgnoreCase("result"))
      {
        localTableItem.setData(localObject);
        localTableItem.setText(3, this.a.a(this.b.getObject("")));
      }
      else if ((localObject != null) && ((localObject instanceof List)) && (((List)localObject).size() > 0))
      {
        localTableItem.setData(localObject);
        if ((((List)localObject).size() > 0) && ((((List)localObject).get(0) instanceof List)))
        {
          List localList = (List)((List)localObject).get(0);
          String str2 = "";
          for (int j = 0; j < localList.size(); j++)
          {
            if (localList.get(j) == null)
              continue;
            str2 = str2 + localList.get(j).toString() + ",";
          }
          localTableItem.setText(3, str2);
        }
        else
        {
          localTableItem.setText(3, this.a.a(((List)localObject).get(0)));
        }
      }
      else
      {
        localTableItem.setText(3, this.a.a(localObject));
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aD
 * JD-Core Version:    0.6.0
 */