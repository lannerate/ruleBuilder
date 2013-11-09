package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.d.t;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class ag
  implements Listener
{
  ag(W paramW)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    t localt = new t(W.c(this.a).getShell(), this.a.q().getEnvionment());
    if ((localt.open() == 0) && (localt.a().size() > 0))
    {
      HashMap localHashMap = localt.a();
      List localList = this.a.q().getPageFields();
      for (int i = 0; i < localList.size(); i++)
      {
        PageFieldModel localPageFieldModel = (PageFieldModel)localList.get(i);
        if (localHashMap.get(localPageFieldModel.getVariableName().toLowerCase()) == null)
          continue;
        if ((localHashMap.get(localPageFieldModel.getVariableName().toLowerCase()) instanceof FieldModel))
        {
          localPageFieldModel.setLen(((FieldModel)localHashMap.get(localPageFieldModel.getVariableName().toLowerCase())).getLen());
          localPageFieldModel.setPropertyValue("maxlen", ((FieldModel)localHashMap.get(localPageFieldModel.getVariableName().toLowerCase())).getLen());
        }
        if ((!localPageFieldModel.getNullType().equalsIgnoreCase("null")) || (!((FieldModel)localHashMap.get(localPageFieldModel.getVariableName().toLowerCase())).isUnNull()))
          continue;
        localPageFieldModel.setNullType("notnull");
      }
      this.a.q().setModified(true);
      this.a.update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.ag
 * JD-Core Version:    0.6.0
 */