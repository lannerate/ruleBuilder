package com.flagleader.builder.a.d;

import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class aN
  implements Listener
{
  aN(aL paramaL)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if (aI.d(aL.a(this.a)) != null)
    {
      aO localaO = new aO(aL.a(this.a), aI.d(aL.a(this.a)).getText(0), aI.d(aL.a(this.a)).getText(1), aI.d(aL.a(this.a)).getText(2));
      if ((localaO.open() == 0) && (localaO.a().length() > 0) && ((!localaO.a().equals(aI.d(aL.a(this.a)).getText(0))) || (!localaO.b().equals(aI.d(aL.a(this.a)).getText(1)))))
      {
        aI.d(aL.a(this.a)).setText(0, localaO.a());
        aI.d(aL.a(this.a)).setText(1, localaO.b());
        aI.d(aL.a(this.a)).setText(2, localaO.c());
        if (aL.a(this.a).e().getPropertiesList().get(aI.a(aL.a(this.a)).getSelectionIndex()) != null)
        {
          AdvancedProperty localAdvancedProperty = (AdvancedProperty)aL.a(this.a).e().getPropertiesList().get(aI.a(aL.a(this.a)).getSelectionIndex());
          localAdvancedProperty.setKey(localaO.a());
          localAdvancedProperty.setProperty(localaO.b());
          aL.a(this.a).e().setModified(true);
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aN
 * JD-Core Version:    0.6.0
 */