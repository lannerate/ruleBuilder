package com.flagleader.builder.a.d;

import com.flagleader.repository.export.PageElementModel;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Listener;

class Q
  implements Listener
{
  Q(P paramP, Item[] paramArrayOfItem)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if ((this.b[0].getData() instanceof PageElementModel))
    {
      PageElementModel localPageElementModel1 = (PageElementModel)this.b[0].getData();
      PageElementModel localPageElementModel2 = new PageElementModel();
      localPageElementModel2.setDisplayName(localPageElementModel1.getDisplayName() + "_" + localPageElementModel1.getChildrenCount());
      localPageElementModel2.setElementType(localPageElementModel1.getElementType());
      localPageElementModel1.addChildElement(localPageElementModel2);
      Item localItem = this.a.d(null);
      localItem.setData(localPageElementModel2);
      this.a.c(localItem);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.Q
 * JD-Core Version:    0.6.0
 */