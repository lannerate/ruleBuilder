package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.b.w;
import com.flagleader.builder.dialogs.b.z;
import com.flagleader.export.PagesMessages;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.rom.AbstractBOEditen;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Listener;

class Z
  implements Listener
{
  Z(W paramW, Item[] paramArrayOfItem)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    w localw = new w(W.c(this.a).getShell(), this.a.q().getEnvionment());
    if ((localw.open() == 0) && (localw.a().size() > 0))
    {
      PageFieldModel localPageFieldModel1 = (PageFieldModel)this.b[0].getData();
      List localList = localw.a();
      for (int i = 0; i < localList.size(); i++)
      {
        PageFieldModel localPageFieldModel2 = new PageFieldModel();
        z localz = (z)localList.get(i);
        String[] arrayOfString = localPageFieldModel2.getPageTypeNames();
        for (int j = 0; j < arrayOfString.length; j++)
          if (this.a.q().getPreferences().getStringArray(localPageFieldModel1.getInputType() + "." + arrayOfString[j]) != null)
            localPageFieldModel2.setPageTypeValue(arrayOfString[j], this.a.q().getPreferences().getStringArray(localPageFieldModel1.getInputType() + "." + arrayOfString[j])[0]);
          else if (this.a.q().getPreferences().getStringArray(localPageFieldModel1.getResultType() + "." + arrayOfString[j]) != null)
            localPageFieldModel2.setPageTypeValue(arrayOfString[j], this.a.q().getPreferences().getStringArray(localPageFieldModel1.getResultType() + "." + arrayOfString[j])[0]);
          else
            localPageFieldModel2.setPageTypeValue(arrayOfString[j], localPageFieldModel1.getPageTypeValue(arrayOfString[j]));
        localPageFieldModel2.setVariableName(localPageFieldModel1.getVariableName() + "_" + localz.a);
        localPageFieldModel2.setValueType(localz.b.getValueType());
        localPageFieldModel2.setDisplayName(localz.b.getDisplayName());
        if ((localz.b instanceof FieldModel))
        {
          localPageFieldModel2.setLen(((FieldModel)localz.b).getLen());
          localPageFieldModel2.setPropertyValue("fieldName", ((FieldModel)localz.b).getFieldName());
        }
        localPageFieldModel1.addChildElement(localPageFieldModel2);
        this.a.b(localPageFieldModel2);
        Item localItem = this.a.d(this.b[0]);
        localItem.setData(localPageFieldModel2);
        this.a.c(localItem);
      }
      this.a.q().setModified(true);
      this.a.b(this.b[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.Z
 * JD-Core Version:    0.6.0
 */