package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class G extends f
{
  private Envionment a = null;
  private Combo b;
  private SheetTable c = null;
  private int d = -1;
  private List e = new ArrayList();

  public G(Envionment paramEnvionment)
  {
    super(Display.getCurrent().getActiveShell());
    this.a = paramEnvionment;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    c("title.SelectSheetDialog");
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = a(localComposite1, 250, 30, 2);
    this.b = b(localComposite2, "selectSheet.SelectSheetDialog", 12, 160, 18, 2);
    getShell().setCursor(getShell().getDisplay().getSystemCursor(1));
    Iterator localIterator = this.a.getAcceptElements(new H(this));
    while (localIterator.hasNext())
    {
      SheetTable localSheetTable = (SheetTable)localIterator.next();
      this.e.add(localSheetTable);
    }
    getShell().setCursor(null);
    String[] arrayOfString = new String[this.e.size() + 2];
    arrayOfString[0] = ValueLibrary.DISPLAYNAME;
    arrayOfString[1] = VariableLibrary.DISPLAYNAME;
    for (int i = 0; i < this.e.size(); i++)
      arrayOfString[(i + 2)] = ((SheetTable)this.e.get(i)).getDisplayName();
    this.b.setItems(arrayOfString);
    if (this.b.getItemCount() < 20)
      this.b.setVisibleItemCount(this.b.getItemCount());
    else
      this.b.setVisibleItemCount(20);
    return localComposite1;
  }

  protected void okPressed()
  {
    if (this.b.getSelectionIndex() >= 2)
      this.c = ((SheetTable)this.e.get(this.b.getSelectionIndex()));
    else
      this.d = this.b.getSelectionIndex();
    super.okPressed();
  }

  public SheetTable a()
  {
    return this.c;
  }

  public int b()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.G
 * JD-Core Version:    0.6.0
 */