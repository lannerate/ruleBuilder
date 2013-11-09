package com.flagleader.builder.widget;

import com.flagleader.engine.Property;
import com.flagleader.manager.d.c;
import com.flagleader.manager.e.y;
import com.flagleader.manager.e.z;
import com.flagleader.repository.IElement;
import java.util.Date;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class E
  implements y
{
  private Table a = null;
  private Menu b = null;

  public Table a(Composite paramComposite, int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    this.a = new Table(paramComposite, paramInt);
    this.a.setLayoutData(new GridData(1808));
    this.a.setHeaderVisible(true);
    this.a.setLinesVisible(true);
    this.a.addMouseListener(new F(this));
    b();
    Display localDisplay = Display.getCurrent();
    I localI = new I(this);
    localDisplay.timerExec(1000, localI);
    return this.a;
  }

  private void a()
  {
    if ((this.a == null) || (this.a.isDisposed()))
      return;
    TableItem[] arrayOfTableItem = this.a.getItems();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if ((arrayOfTableItem[i].getData() == null) || (!(arrayOfTableItem[i].getData() instanceof z)) || (!((z)arrayOfTableItem[i].getData()).i()))
        continue;
      TableEditor localTableEditor = (TableEditor)arrayOfTableItem[i].getData("edit");
      localTableEditor.getEditor().dispose();
      localTableEditor.setEditor(null, arrayOfTableItem[i], 2);
      arrayOfTableItem[i].dispose();
    }
  }

  private void b()
  {
    TableColumn localTableColumn = new TableColumn(this.a, 8388608);
    localTableColumn.setText("");
    localTableColumn.setWidth(150);
    localTableColumn.setMoveable(false);
    localTableColumn.setText(c.b("threadname.ThreadMonitorTable"));
    localTableColumn = new TableColumn(this.a, 8388608);
    localTableColumn.setText("");
    localTableColumn.setWidth(150);
    localTableColumn.setMoveable(false);
    localTableColumn.setText(c.b("starttime.ThreadMonitorTable"));
    localTableColumn = new TableColumn(this.a, 8388608);
    localTableColumn.setText("");
    localTableColumn.setWidth(150);
    localTableColumn.setMoveable(false);
    localTableColumn.setText(c.b("percent.ThreadMonitorTable"));
    localTableColumn = new TableColumn(this.a, 8388608);
    localTableColumn.setText("");
    localTableColumn.setWidth(250);
    localTableColumn.setMoveable(false);
    localTableColumn.setText(c.b("threadinfo.ThreadMonitorTable"));
  }

  public void a(z paramz)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramz.h().getDisplayName());
    localTableItem.setData(paramz);
    localTableItem.setText(1, Property.getInstance().formatTime(new Date(paramz.d())));
    localTableItem.setText(3, paramz.a());
    ProgressBar localProgressBar = new ProgressBar(this.a, 256);
    localProgressBar.setLayoutData(new GridData(130, 16));
    localProgressBar.setMaximum(100);
    TableEditor localTableEditor = new TableEditor(this.a);
    localTableEditor.horizontalAlignment = 16384;
    localTableEditor.grabHorizontal = true;
    localTableEditor.setEditor(localProgressBar, localTableItem, 2);
    localTableItem.setData("edit", localTableEditor);
    paramz.a(new J(this, localTableItem, localProgressBar, paramz));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.E
 * JD-Core Version:    0.6.0
 */