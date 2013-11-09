package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.f;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.lang.info.InfoClass;
import com.flagleader.repository.lang.info.InfoMethod;
import com.flagleader.repository.lang.info.InfoParameter;
import java.util.Iterator;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class F extends f
{
  private Text c;
  private InfoMethod d;
  Table a;

  public F(ClassInfoEditor paramClassInfoEditor)
  {
    super(Display.getCurrent().getActiveShell());
  }

  public F(ClassInfoEditor paramClassInfoEditor, InfoMethod paramInfoMethod)
  {
    super(Display.getCurrent().getActiveShell());
    this.d = paramInfoMethod;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(h.a(250, 100));
    localComposite.setLayout(h.a(1));
    i locali = new i(false, false);
    this.a = locali.a(localComposite, 68352);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = ClassInfoEditor.a(this.b, "type.ClassInfoEditor");
    arrayOfString[1] = ClassInfoEditor.a(this.b, "disname.ClassInfoEditor");
    locali.a(arrayOfString, null, null);
    this.a.setLayoutData(new GridData(1808));
    this.a.setHeaderVisible(true);
    this.a.setLinesVisible(true);
    Iterator localIterator = this.d.getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof InfoParameter))
        continue;
      TableItem localTableItem = new TableItem(this.a, 0);
      localTableItem.setText(0, ((InfoParameter)localObject).getTypeName());
      localTableItem.setText(1, ((InfoParameter)localObject).getDisplayName());
      localTableItem.setData(localObject);
    }
    Object localObject = new TableEditor(this.a);
    this.a.addMouseListener(new G(this, (TableEditor)localObject));
    return (Control)localComposite;
  }

  protected void okPressed()
  {
    for (int i = 0; i < this.a.getItemCount(); i++)
    {
      TableItem localTableItem = this.a.getItem(i);
      if (((InfoParameter)localTableItem.getData()).getDisplayName().equals(localTableItem.getText(1)))
        continue;
      ((InfoParameter)localTableItem.getData()).setDisplayName(localTableItem.getText(1));
      this.d.getInfoClass().setModified(true);
    }
    close();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.F
 * JD-Core Version:    0.6.0
 */