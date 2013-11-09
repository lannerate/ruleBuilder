package com.flagleader.builder.a;

import com.flagleader.repository.IElement;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class aC extends SelectionAdapter
{
  aC(ax paramax)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (paramSelectionEvent.detail == 32)
    {
      TableTreeItem localTableTreeItem = (TableTreeItem)paramSelectionEvent.item;
      if (localTableTreeItem != null)
      {
        if (this.a.b())
        {
          localTableTreeItem.setChecked(!localTableTreeItem.getChecked());
          return;
        }
        boolean bool = localTableTreeItem.getChecked();
        if (this.a.a((IElement)localTableTreeItem.getData(), localTableTreeItem.getChecked()))
          for (int i = 0; i < ax.a(this.a).getSelectionCount(); i++)
          {
            if (ax.a(this.a).getSelection()[i].equals(localTableTreeItem))
              continue;
            ax.a(this.a).getSelection()[i].setChecked(localTableTreeItem.getChecked());
            this.a.a((IElement)ax.a(this.a).getSelection()[i].getData(), ax.a(this.a).getSelection()[i].getChecked());
          }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aC
 * JD-Core Version:    0.6.0
 */