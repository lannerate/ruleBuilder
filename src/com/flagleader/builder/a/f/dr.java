package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.actions.aq;
import com.flagleader.db.Sheet;
import com.flagleader.engine.IRuleLog;
import com.flagleader.repository.d.r;
import com.flagleader.repository.tree.IRuleClass;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class dr
  implements Runnable
{
  dr(do paramdo, List paramList, IRuleLog paramIRuleLog)
  {
  }

  public void run()
  {
    for (int i = 0; i < do.b(this.a).getItemCount(); i++)
    {
      TableItem localTableItem = do.b(this.a).getItems()[i];
      localTableItem.setData(null);
      localTableItem.setText(3, "");
      String str1 = localTableItem.getText(4);
      Object localObject1 = null;
      Object localObject2;
      if (str1.indexOf(".") > 0)
      {
        int j = 0;
        while (j < this.b.size())
          try
          {
            if (do.a(this.a, str1.substring(0, str1.lastIndexOf("."))).isAssignableFrom(this.b.get(j).getClass()))
            {
              Object localObject3 = this.b.get(j);
              localObject1 = r.b(localObject3, str1.substring(str1.lastIndexOf(".") + 1));
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            j++;
          }
      }
      else
      {
        localObject2 = do.g(this.a).get(str1);
        if (str1.equalsIgnoreCase("ruleLog"))
          localObject1 = this.c;
        else if (localObject2 != null)
          localObject1 = localObject2;
      }
      if (str1.equalsIgnoreCase("snapShot"))
      {
        localTableItem.setData(localObject1);
        localTableItem.setText(3, ResourceTools.getMessage("logClick.Test"));
      }
      else if ((localObject1 != null) && ((localObject1 instanceof List)) && (((List)localObject1).size() > 0))
      {
        localTableItem.setData(localObject1);
        if ((((List)localObject1).size() > 0) && ((((List)localObject1).get(0) instanceof List)))
        {
          localObject2 = (List)((List)localObject1).get(0);
          String str2 = "";
          for (int k = 0; k < ((List)localObject2).size(); k++)
          {
            if (((List)localObject2).get(k) == null)
              continue;
            str2 = str2 + ((List)localObject2).get(k).toString() + ",";
          }
          localTableItem.setText(3, str2);
        }
        else
        {
          localTableItem.setText(3, this.a.a(((List)localObject1).get(0)));
        }
      }
      else if ((localObject1 != null) && ((localObject1 instanceof IRuleLog)))
      {
        do.c(this.a).getMessageWindow().a((IRuleLog)localObject1, this.a.e().getCompilePackage());
        localTableItem.setData(localObject1);
        localTableItem.setText(3, ResourceTools.getMessage("logClick.Test"));
      }
      else if ((localObject1 != null) && ((localObject1 instanceof Sheet)))
      {
        localTableItem.setData(localObject1);
        localTableItem.setText(3, ResourceTools.getMessage("logClick.Test"));
      }
      else
      {
        localTableItem.setText(3, this.a.a(localObject1));
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.dr
 * JD-Core Version:    0.6.0
 */