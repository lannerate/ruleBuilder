package com.flagleader.builder.a.g;

import com.flagleader.builder.dialogs.M;
import com.flagleader.builder.dialogs.m;
import com.flagleader.builder.dialogs.n;
import com.flagleader.builder.shell.RuleTraceViewer;
import com.flagleader.builder.shell.SnapTraceViewer;
import com.flagleader.db.Sheet;
import com.flagleader.engine.IRuleLog;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestObjectInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class o extends MouseAdapter
{
  private TableItem b;

  public o(k paramk)
  {
    k.a(paramk, new TableEditor(k.b(paramk)));
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
  }

  private void a(TableItem paramTableItem, Point paramPoint, int paramInt)
  {
    Rectangle localRectangle = paramTableItem.getBounds(paramInt);
    if (localRectangle.contains(paramPoint))
    {
      M localM = new M(this.b.getText(paramInt), 0, 1);
      if (localM.open() == 0)
      {
        String str = localM.a();
        if (!str.equals(this.b.getText(paramInt)))
        {
          this.b.setText(paramInt, str);
          a(str, paramInt, this.b);
        }
      }
    }
  }

  private void a(Table paramTable, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(paramTable.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.b, paramInt);
    paramText.addFocusListener(new p(this, paramText, paramInt));
    paramText.addTraverseListener(new q(this, paramText, paramInt));
  }

  private void a(String paramString, int paramInt, TableItem paramTableItem)
  {
    TestObjectInfo localTestObjectInfo = (TestObjectInfo)paramTableItem.getData("info");
    if ((paramInt == k.c(this.a) - 4) && (!localTestObjectInfo.getInitialValue().equals(paramString)) && ((paramString.length() == 0) || (localTestObjectInfo.checkValue(paramString))))
    {
      paramTableItem.setText(paramInt, paramString);
      localTestObjectInfo.setInitialValue(paramString);
      k.d(this.a).setModified(true);
    }
    if ((paramInt == k.c(this.a) - 3) && (!localTestObjectInfo.getExpectValue().equals(paramString)) && ((paramString.length() == 0) || (localTestObjectInfo.checkValue(paramString))))
    {
      paramTableItem.setText(paramInt, paramString);
      localTestObjectInfo.setExpectValue(paramString);
      k.d(this.a).setModified(true);
    }
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    this.b = k.b(this.a).getItem(localPoint);
    k.a(this.a, this.b);
    if (this.b == null)
      return;
    for (int i = k.c(this.a) - 4; i <= k.c(this.a) - 3; i++)
      a(this.b, localPoint, i);
    if ((this.b.getBounds(k.c(this.a) - 2).contains(localPoint)) && (this.b.getText(k.c(this.a) - 2) != null))
    {
      Object localObject;
      Shell localShell;
      Display localDisplay;
      if ((this.b.getData() != null) && ((this.b.getData() instanceof List)))
      {
        if ((this.b.getText(0).equalsIgnoreCase("snapShot")) && ((this.b.getData() instanceof LinkedList)))
        {
          localObject = new SnapTraceViewer((LinkedList)this.b.getData(), k.d(this.a).getMainPackage(), k.e(this.a));
          localShell = ((SnapTraceViewer)localObject).b(null);
          localDisplay = localShell.getDisplay();
          while (!localShell.isDisposed())
          {
            if (localDisplay.readAndDispatch())
              continue;
            localDisplay.sleep();
          }
        }
        else if ((this.b.getData() instanceof ArrayList))
        {
          localObject = new n((List)this.b.getData(), 0, 1);
          ((n)localObject).open();
        }
      }
      else if ((this.b.getData() != null) && ((this.b.getData() instanceof IRuleLog)))
      {
        localObject = new RuleTraceViewer((IRuleLog)this.b.getData(), k.d(this.a).getMainPackage(), k.e(this.a));
        localShell = ((RuleTraceViewer)localObject).b(null);
        localDisplay = localShell.getDisplay();
        while (!localShell.isDisposed())
        {
          if (localDisplay.readAndDispatch())
            continue;
          localDisplay.sleep();
        }
      }
      else if ((this.b.getData() != null) && ((this.b.getData() instanceof Sheet)))
      {
        localObject = new m((Sheet)this.b.getData(), 0, 1);
        ((m)localObject).open();
      }
      else
      {
        localObject = new M(this.b.getText(k.c(this.a) - 2), 0, 1);
        ((M)localObject).open();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.o
 * JD-Core Version:    0.6.0
 */