package com.flagleader.builder.e.h;

import com.flagleader.builder.ResourceTools;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.XmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class f extends WizardPage
{
  private com.flagleader.builder.widget.i b = new com.flagleader.builder.widget.i(false, true);
  private Table c;
  private LinkedHashMap d = new LinkedHashMap();
  LinkedHashMap a = new LinkedHashMap();
  private TableItem e;
  private TableEditor f;
  private ArrayList g = new ArrayList();

  public f(j paramj)
  {
    super("ReplaceVariablePage3");
    setTitle(a("title.ReplaceVariablePage3"));
    setDescription(a("describe.ReplaceVariablePage3"));
  }

  public void createControl(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(1));
    localComposite.setLayoutData(a(550, 400));
    com.flagleader.builder.widget.i locali = new com.flagleader.builder.widget.i(false, true);
    this.c = locali.a(localComposite, ".ReplaceVariablePage3", 68352);
    this.f = new TableEditor(this.c);
    this.c.addMouseListener(new g(this));
    b();
    setControl(localComposite);
  }

  private void a(TableItem paramTableItem, int paramInt)
  {
    CCombo localCCombo = new CCombo(this.c, 8);
    String[] arrayOfString = new String[this.d.size()];
    this.g.clear();
    Iterator localIterator = this.d.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      this.g.add(localObject);
      arrayOfString[(i++)] = b(localObject);
    }
    localCCombo.setItems(arrayOfString);
    localCCombo.setText(paramTableItem.getText(paramInt));
    if (localCCombo.getItemCount() < 20)
      localCCombo.setVisibleItemCount(localCCombo.getItemCount());
    else
      localCCombo.setVisibleItemCount(20);
    this.f.horizontalAlignment = 16384;
    this.f.grabHorizontal = true;
    this.f.minimumWidth = 50;
    this.f.setEditor(localCCombo, paramTableItem, paramInt);
    localCCombo.addFocusListener(new h(this, localCCombo, paramTableItem));
    localCCombo.addTraverseListener(new i(this, localCCombo, paramTableItem));
    localCCombo.setFocus();
  }

  public void a(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      Object localObject = paramList.get(i);
      if (this.a.containsKey(localObject))
        continue;
      this.a.put(localObject, null);
    }
    b();
  }

  public void b(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      Object localObject = paramList.get(i);
      this.a.remove(localObject);
    }
    b();
  }

  private String a(Object paramObject)
  {
    if ((paramObject instanceof FieldModel))
      return ((FieldModel)paramObject).getDisplayName();
    if ((paramObject instanceof IVariableObject))
      return ((IVariableObject)paramObject).getDisplayName();
    return "";
  }

  private String b(Object paramObject)
  {
    if ((paramObject instanceof FieldModel))
      return ((FieldModel)paramObject).getShowDisplayName();
    if ((paramObject instanceof IVariableObject))
      return ((IVariableObject)paramObject).getShowDisplayName();
    return "";
  }

  private String c(Object paramObject)
  {
    if ((paramObject instanceof FieldModel))
      return ((FieldModel)paramObject).getValueType();
    if ((paramObject instanceof IVariableObject))
      return ((IVariableObject)paramObject).getValueType();
    return "";
  }

  public boolean a(Object paramObject1, Object paramObject2)
  {
    return c(paramObject1).equalsIgnoreCase(c(paramObject2));
  }

  public void c(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      Object localObject1 = paramList.get(i);
      if (this.d.containsKey(localObject1))
        continue;
      Object localObject2 = null;
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        if ((this.a.get(localObject3) != null) || (!a(localObject3, localObject1)))
          continue;
        localObject2 = localObject3;
        this.a.put(localObject3, localObject1);
        break;
      }
      this.d.put(localObject1, localObject2);
    }
    b();
  }

  public void d(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      Object localObject1 = paramList.get(i);
      this.d.remove(localObject1);
      if (!this.a.containsValue(localObject1))
        continue;
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((this.a.get(localObject2) == null) || (!this.a.get(localObject2).equals(localObject1)))
          continue;
        this.a.put(localObject2, null);
      }
    }
    b();
  }

  public LinkedHashMap a()
  {
    return this.a;
  }

  private Image a(ITreeNode paramITreeNode)
  {
    return ResourceTools.getIcon(paramITreeNode);
  }

  private void a(TableItem paramTableItem, Object paramObject)
  {
  }

  private void b()
  {
    this.c.removeAll();
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      TableItem localTableItem = new TableItem(this.c, 0);
      if ((localObject1 instanceof FieldModel))
      {
        localTableItem.setText(0, ((FieldModel)localObject1).getShowDisplayName());
        localTableItem.setText(1, ((FieldModel)localObject1).getValueType());
        localTableItem.setText(2, ((FieldModel)localObject1).getValueName());
      }
      else if ((localObject1 instanceof IVariableObject))
      {
        localTableItem.setText(0, ((IVariableObject)localObject1).getShowDisplayName());
        localTableItem.setText(1, ((IVariableObject)localObject1).getValueType());
        localTableItem.setText(2, ((IVariableObject)localObject1).getValueName());
      }
      else if ((localObject1 instanceof XmlNode))
      {
        localTableItem.setText(0, ((XmlNode)localObject1).getShowDisplayName());
        localTableItem.setText(1, "string");
        localTableItem.setText(2, ((XmlNode)localObject1).getValueName());
      }
      if (this.a.get(localObject1) != null)
      {
        Object localObject2 = this.a.get(localObject1);
        if ((localObject2 instanceof FieldModel))
          localTableItem.setText(3, ((FieldModel)localObject2).getShowDisplayName());
        else if ((localObject2 instanceof IVariableObject))
          localTableItem.setText(3, ((IVariableObject)localObject2).getShowDisplayName());
        else if ((localObject2 instanceof XmlNode))
          localTableItem.setText(3, ((XmlNode)localObject2).getShowDisplayName());
      }
      localTableItem.setData(localObject1);
    }
  }

  private void c()
  {
    b(null);
  }

  private void b(String paramString)
  {
    setErrorMessage(paramString);
    setPageComplete(paramString == null);
  }

  protected GridLayout a(int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = paramInt;
    return localGridLayout;
  }

  protected String a(String paramString)
  {
    return ResourceTools.getMessage(paramString);
  }

  protected GridData a(int paramInt1, int paramInt2)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = paramInt1;
    localGridData.heightHint = paramInt2;
    return localGridData;
  }

  private void a(Composite paramComposite, int paramInt)
  {
    Label localLabel = new Label(paramComposite, 259);
    GridData localGridData = new GridData(768);
    localGridData.horizontalSpan = paramInt;
    localLabel.setLayoutData(localGridData);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.h.f
 * JD-Core Version:    0.6.0
 */