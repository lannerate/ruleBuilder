package com.flagleader.builder.a.f;

import com.flagleader.builder.dialogs.M;
import com.flagleader.builder.dialogs.m;
import com.flagleader.builder.dialogs.n;
import com.flagleader.builder.shell.RuleTraceViewer;
import com.flagleader.builder.shell.SnapTraceViewer;
import com.flagleader.builder.widget.p;
import com.flagleader.db.Sheet;
import com.flagleader.engine.IRuleLog;
import com.flagleader.repository.tree.IRuleClass;
import java.util.ArrayList;
import java.util.HashMap;
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

class du extends MouseAdapter
{
  private TableItem b;

  public du(do paramdo)
  {
    do.a(paramdo, new TableEditor(do.b(paramdo)));
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
  }

  private void a(TableItem paramTableItem, Point paramPoint, int paramInt)
  {
    Rectangle localRectangle = paramTableItem.getBounds(paramInt);
    if (localRectangle.contains(paramPoint))
    {
      Text localText = new p(do.c(this.a)).a(do.b(this.a), 4);
      localText.setText(paramTableItem.getText(paramInt));
      a(do.b(this.a), localText, do.d(this.a), paramInt);
      localText.setFocus();
    }
  }

  private void a(Table paramTable, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(paramTable.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.b, paramInt);
    paramText.addFocusListener(new dv(this, paramText, paramInt));
    paramText.addTraverseListener(new dw(this, paramText, paramInt));
  }

  private void a(String paramString, int paramInt, TableItem paramTableItem)
  {
    if (paramInt == 2)
    {
      paramTableItem.setText(paramInt, paramString);
      do.e(this.a).put(paramTableItem.getText(4), paramString);
      this.a.e().setPropertyValue(paramTableItem.getText(4), paramString);
      this.a.e().setNeedSave();
    }
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    this.b = do.b(this.a).getItem(localPoint);
    if (this.b == null)
      return;
    for (int i = 2; i <= 2; i++)
      a(this.b, localPoint, i);
    if ((this.b.getBounds(3).contains(localPoint)) && (this.b.getText(3) != null))
    {
      Object localObject;
      Shell localShell;
      Display localDisplay;
      if ((this.b.getData() != null) && ((this.b.getData() instanceof List)))
      {
        if ((this.b.getText(4).equalsIgnoreCase("snapShot")) && ((this.b.getData() instanceof LinkedList)))
        {
          localObject = new SnapTraceViewer((LinkedList)this.b.getData(), this.a.e().getCompilePackage(), do.c(this.a));
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
        localObject = new RuleTraceViewer((IRuleLog)this.b.getData(), this.a.e().getMainPackage(), do.c(this.a));
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
        localObject = new M(this.b.getText(3), 0, 1);
        ((M)localObject).open();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.du
 * JD-Core Version:    0.6.0
 */