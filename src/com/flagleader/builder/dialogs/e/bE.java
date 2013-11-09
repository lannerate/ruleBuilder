package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.builder.widget.c;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.rlm.editen.ISheetFunctionEditen;
import com.flagleader.repository.rlm.value.SheetFunction;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class bE extends f
{
  private static final int a = 450;
  private static final int b = 300;
  private String[] c;
  private String[] d;
  private String[] e;
  private List f;
  private Text g;
  private Text h;
  private Table i;
  private HashMap j = new HashMap();
  private ISheetFunctionEditen k = null;
  private boolean l = false;
  private TableEditor m;
  private TableItem n;

  public bE(Shell paramShell, ISheetFunctionEditen paramISheetFunctionEditen)
  {
    super(paramShell);
    this.k = paramISheetFunctionEditen;
    this.f = paramISheetFunctionEditen.getSelects();
    this.c = paramISheetFunctionEditen.getFunctionNames();
    this.e = paramISheetFunctionEditen.getAsNameSelects();
    this.d = new String[this.f.size()];
    for (int i1 = 0; i1 < this.f.size(); i1++)
      this.d[i1] = ((IBusinessObject)this.f.get(i1)).getDisplayName();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(new GridLayout());
    localComposite2.setLayoutData(new GridData(1808));
    d(localComposite2);
    Composite localComposite3 = new Composite(localComposite1, 0);
    localComposite3.setLayoutData(new GridData(1808));
    localComposite3.setLayout(a(7));
    e(localComposite3);
    b(localComposite1);
    return localComposite1;
  }

  private void a(StringBuffer paramStringBuffer)
  {
  }

  private void d(Composite paramComposite)
  {
    f(paramComposite);
    b(this.i);
    a(this.i);
    this.m = new TableEditor(this.i);
    this.i.addKeyListener(new bF(this));
    this.i.addMouseMoveListener(new bI(this));
    this.i.addMouseListener(new bJ(this));
  }

  private void h()
  {
    bQ localbQ = new bQ(this);
    if ((localbQ.open() == 0) && (localbQ.a().length() > 0))
    {
      TableItem localTableItem = new TableItem(this.i, 0);
      IBusinessObject localIBusinessObject = (IBusinessObject)this.f.get(localbQ.b());
      localTableItem.setText(0, localbQ.c());
      localTableItem.setText(1, localIBusinessObject.getDisplayName());
      localTableItem.setText(2, localbQ.a());
      localTableItem.setData(localIBusinessObject);
      this.l = true;
    }
  }

  private void i()
  {
    IBusinessObject localIBusinessObject = (IBusinessObject)j().getData();
    int i1 = -1;
    for (int i2 = 0; i2 < this.f.size(); i2++)
    {
      if (!((IBusinessObject)this.f.get(i2)).equals(localIBusinessObject))
        continue;
      i1 = i2;
      break;
    }
    bQ localbQ = new bQ(this, j().getText(0), i1, j().getText(2));
    if ((localbQ.open() == 0) && (localbQ.a().length() > 0) && ((!localbQ.c().equals(j().getText(2))) || (i1 != localbQ.b()) || (!localbQ.a().equals(j().getText(0)))))
    {
      localIBusinessObject = (IBusinessObject)this.f.get(localbQ.b());
      j().setText(2, localbQ.a());
      j().setText(1, localIBusinessObject.getDisplayName());
      j().setText(0, localbQ.c());
      j().setData(localIBusinessObject);
      this.l = true;
    }
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(this.i.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.n, paramInt);
    paramText.addFocusListener(new bK(this, paramText, paramTableItem, paramInt, paramTableEditor));
    paramText.addTraverseListener(new bL(this, paramText, paramTableItem, paramInt, paramTableEditor));
  }

  private void e(Composite paramComposite)
  {
    Button localButton1 = g(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new bM(this));
    Button localButton2 = g(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new bN(this));
    Button localButton3 = g(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new bO(this));
    localButton1 = g(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new bP(this));
    Button localButton4 = g(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new bG(this));
    Button localButton5 = g(paramComposite);
    localButton5.setText(b("reset.DataDialog"));
    localButton5.addSelectionListener(new bH(this));
  }

  private Table f(Composite paramComposite)
  {
    this.i = new Table(paramComposite, 67586);
    GridData localGridData = new GridData();
    localGridData.widthHint = 450;
    localGridData.heightHint = 300;
    this.i.setLayoutData(localGridData);
    this.i.setLinesVisible(true);
    return this.i;
  }

  private void a(Table paramTable)
  {
    List localList = this.k.getSelectedElements();
    if (localList != null)
    {
      paramTable.removeAll();
      Control[] arrayOfControl = paramTable.getChildren();
      for (int i1 = 0; i1 < arrayOfControl.length; i1++)
        arrayOfControl[i1].dispose();
      for (i1 = 0; i1 < localList.size(); i1++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        SheetFunction localSheetFunction = (SheetFunction)localList.get(i1);
        IBusinessObject localIBusinessObject = localSheetFunction.getField();
        if (localIBusinessObject != null)
        {
          localTableItem.setText(new String[] { localSheetFunction.getFuncName(), localIBusinessObject.getDisplayName(), localSheetFunction.getAsName() });
          localTableItem.setData(localIBusinessObject);
        }
        else
        {
          localTableItem.setText(new String[] { localSheetFunction.getFuncName(), b("notExits.TEXT"), localSheetFunction.getAsName() });
          localTableItem.setBackground(h.g);
        }
      }
    }
  }

  private void b(Table paramTable)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("funcName.SelectSheetFunctionsDialog"));
    localTableColumn.setWidth(150);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("fieldName.SelectSheetFunctionsDialog"));
    localTableColumn.setWidth(145);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("asName.SelectSheetFunctionsDialog"));
    localTableColumn.setWidth(145);
  }

  private TableItem j()
  {
    if (this.i.getSelectionIndex() >= 0)
      return this.i.getSelection()[0];
    return null;
  }

  private Button g(Composite paramComposite)
  {
    Button localButton = new Button(paramComposite, 8);
    GridData localGridData = new GridData();
    localGridData.widthHint = 65;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.horizontalIndent = 16;
    localButton.setLayoutData(localGridData);
    return localButton;
  }

  protected void okPressed()
  {
    if (!this.k.isLocked())
    {
      this.k.clearAllChildren();
      TableItem[] arrayOfTableItem = this.i.getItems();
      for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
      {
        if ((arrayOfTableItem[i1].getText(2).length() <= 0) || (arrayOfTableItem[i1].getText(1).length() <= 0))
          continue;
        this.k.addChildElement(new SheetFunction(arrayOfTableItem[i1].getText(0), (IBusinessObject)arrayOfTableItem[i1].getData(), arrayOfTableItem[i1].getText(2)));
      }
      this.k.getRoot().setModified(true);
    }
    close();
  }

  protected void a()
  {
    close();
  }

  public boolean b()
  {
    return this.i.getSelectionCount() > 0;
  }

  public boolean c()
  {
    return this.i.getSelectionCount() > 0;
  }

  public boolean d()
  {
    return this.i.getSelectionCount() > 0;
  }

  public boolean e()
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(c.a());
    if (localObject == null)
      return false;
    if ((localObject instanceof ArrayList))
    {
      ArrayList localArrayList = (ArrayList)localObject;
      for (int i1 = 0; i1 < localArrayList.size(); i1++)
        if ((localArrayList.get(i1) instanceof ArrayList))
          return true;
    }
    return false;
  }

  public void f()
  {
    TableItem[] arrayOfTableItem = this.i.getSelection();
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
      arrayOfTableItem[i1].dispose();
    this.l = true;
  }

  public boolean g()
  {
    return this.l;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bE
 * JD-Core Version:    0.6.0
 */