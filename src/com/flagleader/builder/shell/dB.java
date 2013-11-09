package com.flagleader.builder.shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;

class dB extends SelectionAdapter
{
  dB(ds paramds)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = 0;
    int[] arrayOfInt;
    int j;
    int k;
    if (paramSelectionEvent.detail == 16777218)
    {
      arrayOfInt = ds.c(this.a).getColumnOrder();
      if (arrayOfInt.length > 3)
        do
        {
          j = arrayOfInt[2];
          for (k = 2; k < arrayOfInt.length - 1; k++)
            arrayOfInt[k] = arrayOfInt[(k + 1)];
          arrayOfInt[(arrayOfInt.length - 1)] = j;
          ds.c(this.a).setColumnOrder(arrayOfInt);
        }
        while (((paramSelectionEvent.stateMask & SWT.MOD1) != 0) && (i++ < 5));
      ds.c(this.a).showColumn(this.a.f);
    }
    else if (paramSelectionEvent.detail == 16777217)
    {
      arrayOfInt = ds.c(this.a).getColumnOrder();
      if (arrayOfInt.length > 3)
        do
        {
          j = arrayOfInt[(arrayOfInt.length - 1)];
          for (k = arrayOfInt.length - 1; k > 2; k--)
            arrayOfInt[k] = arrayOfInt[(k - 1)];
          arrayOfInt[2] = j;
          ds.c(this.a).setColumnOrder(arrayOfInt);
        }
        while (((paramSelectionEvent.stateMask & SWT.MOD1) != 0) && (i++ < 5));
      ds.c(this.a).showColumn(this.a.f);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dB
 * JD-Core Version:    0.6.0
 */