package com.flagleader.builder.shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;

class fd extends SelectionAdapter
{
  fd(eV parameV)
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
      arrayOfInt = eV.c(this.a).getColumnOrder();
      if (arrayOfInt.length > 3)
        do
        {
          j = arrayOfInt[2];
          for (k = 2; k < arrayOfInt.length - 1; k++)
            arrayOfInt[k] = arrayOfInt[(k + 1)];
          arrayOfInt[(arrayOfInt.length - 1)] = j;
          eV.c(this.a).setColumnOrder(arrayOfInt);
        }
        while (((paramSelectionEvent.stateMask & SWT.MOD1) != 0) && (i++ < 5));
      eV.c(this.a).showColumn(this.a.f);
    }
    else if (paramSelectionEvent.detail == 16777217)
    {
      arrayOfInt = eV.c(this.a).getColumnOrder();
      if (arrayOfInt.length > 3)
        do
        {
          j = arrayOfInt[(arrayOfInt.length - 1)];
          for (k = arrayOfInt.length - 1; k > 2; k--)
            arrayOfInt[k] = arrayOfInt[(k - 1)];
          arrayOfInt[2] = j;
          eV.c(this.a).setColumnOrder(arrayOfInt);
        }
        while (((paramSelectionEvent.stateMask & SWT.MOD1) != 0) && (i++ < 5));
      eV.c(this.a).showColumn(this.a.f);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fd
 * JD-Core Version:    0.6.0
 */