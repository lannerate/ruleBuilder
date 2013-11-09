package com.flagleader.builder.a.d;

import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;

class aM
  implements Listener
{
  aM(aL paramaL)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    aO localaO = new aO(aL.a(this.a));
    if ((localaO.open() == 0) && (localaO.a().length() > 0))
    {
      TableItem localTableItem = new TableItem(aI.a(aL.a(this.a)), 0);
      localTableItem.setText(new String[] { localaO.a(), localaO.b(), localaO.c() });
      aL.a(this.a).e().getPropertiesList().add(new AdvancedProperty(localaO.a(), localaO.b()));
      aL.a(this.a).e().setModified(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aM
 * JD-Core Version:    0.6.0
 */